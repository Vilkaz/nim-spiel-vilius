package nimgame.it;

import com.google.gson.Gson;
import nimgame.model.*;
import nimgame.service.GameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.UnsupportedEncodingException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GameControllerTest {

    private static final Gson GSON = new Gson();
    private static final String START = "start";
    private static final String PLAY = "play";
    @Autowired
    MockMvc mvc;

    @Autowired
    GameService gameService;

    @Test
    void startingAGame() throws Exception {

        GameStarter gameStarter = new GameStarter(Strategy.RANDOM, FirstTurn.PLAYER);

        MvcResult mvcResult = mvc.perform(post("/api/start")
                .contentType(MediaType.APPLICATION_JSON)
                .content(GSON.toJson(gameStarter)))
                .andExpect(status().isOk())
                .andReturn();

        Game game = createGameFromResponse(mvcResult);
        assertThat(game).isNotNull();
    }

    @Test
    void missingParameterFirstTurn() throws Exception {

        GameStarter gameStarter = new GameStarter(Strategy.RANDOM, null);

        MvcResult mvcResult = apiCall(gameStarter, START);

        Exception exception = mvcResult.getResolvedException();
        assertThat(exception).isNotNull();
    }

    @Test
    void missingParameterStrategy() throws Exception {
        GameStarter gameStarter = new GameStarter(null, FirstTurn.PLAYER);

        MvcResult mvcResult = apiCall(gameStarter, START);

        Exception exception = mvcResult.getResolvedException();
        assertThat(exception).isNotNull();
    }

    @Test
    void statusTest() throws Exception {
        GameStarter gameStarter = new GameStarter(Strategy.RANDOM, FirstTurn.PLAYER);

        apiCall(gameStarter, START);

        Game game = gameService.loadGame();
        assertThat(game).isNotNull();
        assertThat(game.getStrategy()).isEqualTo(Strategy.RANDOM);
        assertThat(game.getMatchesInStack()).isEqualTo(13);
    }

    @Test
    void winningStratFromComputer() throws Exception {
        GameStarter gameStarter = new GameStarter(Strategy.WIN, FirstTurn.PLAYER);

        //Start new Game
        apiCall(gameStarter, START);

        //Game started, lets take 2 matches
        PlayersMove playersMove = new PlayersMove();
        playersMove.setMatchesToTake(2);
        MvcResult mvcResult = apiCall(playersMove, PLAY);

        //we took 2 matches, so there were 11. Computer wants to win, so
        //there should be 9 matches in the game left

        Game game = createGameFromResponse(mvcResult);
        assertThat(game.getMatchesInStack()).isEqualTo(9);

        //lets take 3 matches now
        playersMove.setMatchesToTake(3);
        mvcResult = apiCall(playersMove, PLAY);
        //we took 3 matches from 9, so there were 6. Computer wants to win, so
        //there should be 5 matches in the game left

        game = createGameFromResponse(mvcResult);
        assertThat(game.getMatchesInStack()).isEqualTo(5);

        //lets cheat, lets take 4 matches so that computer loses.
        playersMove.setMatchesToTake(4);
        apiCall(playersMove, PLAY);
        //this is not a valid move, so amount of matches should stay the same
        //lets get the status of game and check it
        mvcResult = mvc.perform(get("/api/status")
                .contentType(MediaType.APPLICATION_JSON)
                .content(GSON.toJson("")))
                .andReturn();
        game = createGameFromResponse(mvcResult);
        assertThat(game.getMatchesInStack()).isEqualTo(5);

        //okay, lets take 1 match then now
        playersMove.setMatchesToTake(1);
        mvcResult = apiCall(playersMove, PLAY);
        // there were 5 matches, we took 1, Computer wants to win, so
        // there should be 1 matches in the game left
        game = createGameFromResponse(mvcResult);
        assertThat(game.getMatchesInStack()).isEqualTo(1);

    }

    private MvcResult apiCall(Object data, String endpoint) throws Exception {
        MvcResult mvcResult;
        mvcResult = mvc.perform(post("/api/" + endpoint)
                .contentType(MediaType.APPLICATION_JSON)
                .content(GSON.toJson(data)))
                .andReturn();
        return mvcResult;
    }

    private Game createGameFromResponse(MvcResult mvcResult) throws UnsupportedEncodingException {
        String contentAsString = mvcResult.getResponse().getContentAsString();
        return GSON.fromJson(contentAsString, Game.class);
    }


}
