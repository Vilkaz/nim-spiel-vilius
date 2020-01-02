package de.holisticon.nimgamevilius.model.validators;

import de.holisticon.nimgamevilius.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MatchesToTakeValidatorTest {


    @Test
    void validMove() {
        MatchesToTakeValidator validator = new MatchesToTakeValidator();
        GameStarter gameStarter = new GameStarter(Strategy.RANDOM, FirstTurn.PLAYER);
        Settings settings = new Settings(gameStarter, 13);
        GameHandler.startGame(settings);
        assertTrue(validator.isValid(2, null));
    }
    @Test
    void invalidMoveByStartingValue() {
        MatchesToTakeValidator validator = new MatchesToTakeValidator();
        GameStarter gameStarter = new GameStarter(Strategy.RANDOM, FirstTurn.PLAYER);
        Settings settings = new Settings(gameStarter, 2);
        GameHandler.startGame(settings);
        assertFalse(validator.isValid(3, null));
    }

    @Test
    void invalidMoveByRunningGame() {
        GameStarter gameStarter = new GameStarter(Strategy.WIN, FirstTurn.PLAYER);
        Settings settings = new Settings(gameStarter, 13);
        GameHandler.startGame(settings);

        PlayersMove playersMove = new PlayersMove();
        playersMove.setMatchesToTake(1);
        GameHandler.play(playersMove); //matches in stack = 9
        GameHandler.play(playersMove);//matches in stack = 5
        GameHandler.play(playersMove); //matches in stack = 1

        MatchesToTakeValidator validator = new MatchesToTakeValidator();
        assertFalse(validator.isValid(3, null));
    }
}
