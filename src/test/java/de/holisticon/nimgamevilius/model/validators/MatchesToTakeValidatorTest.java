package de.holisticon.nimgamevilius.model.validators;

import de.holisticon.nimgamevilius.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class MatchesToTakeValidatorTest {


    @Test
    public void validMove() {
        MatchesToTakeValidator validator = new MatchesToTakeValidator();
        Settings settings = new Settings(Strategy.RANDOM, FirstTurn.COMPUTER);
        settings.setStartingMatchesAmount(13);
        GameHandler.startGame(settings);
        assertTrue(validator.isValid(2, null));
    }
    @Test
    public void invalidMoveByStartingValue() {
        MatchesToTakeValidator validator = new MatchesToTakeValidator();
        Settings settings = new Settings(Strategy.RANDOM, FirstTurn.COMPUTER);
        settings.setStartingMatchesAmount(2);
        GameHandler.startGame(settings);
        assertFalse(validator.isValid(3, null));
    }

    @Test
    public void invalidMoveByRunningGame() {
        Settings settings = new Settings(Strategy.WIN, FirstTurn.PLAYER);
        settings.setStartingMatchesAmount(13);
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
