package nimgame.model.validators;

import nimgame.model.*;
import nimgame.service.GameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MatchesToTakeValidatorTest {

    @Autowired
    GameService gameService;
    @Autowired
    MatchesToTakeValidator validator;


    @Test
    void validMove() {
        GameStarter gameStarter = new GameStarter(Strategy.RANDOM, FirstTurn.PLAYER);
        gameService.startNewGame(gameStarter);
        assertTrue(validator.isValid(2, null));
    }
    @Test
    void invalidMoveByStartingValue() {
        GameStarter gameStarter = new GameStarter(Strategy.RANDOM, FirstTurn.PLAYER);
        gameService.startNewGame(gameStarter);
        Game game = gameService.loadGame();
        game.setMatchesInStack(2);
        gameService.saveGame(game);
        assertFalse(validator.isValid(3, null));
    }

    @Test
    void invalidMoveByRunningGame() {
        GameStarter gameStarter = new GameStarter(Strategy.WIN, FirstTurn.PLAYER);
        gameService.startNewGame(gameStarter);

        PlayersMove playersMove = new PlayersMove();
        playersMove.setMatchesToTake(1);
        gameService.play(playersMove); //matches in stack = 9
        gameService.play(playersMove);//matches in stack = 5
        gameService.play(playersMove); //matches in stack = 1

        assertFalse(validator.isValid(3, null));
    }
}
