package nimgame.model.validators;

import nimgame.model.*;
import nimgame.service.GameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class MatchesToTakeValidatorTest {

    @Test
    void validMove() {
        Game game = GameBuilder.aGame()
                .withFirstTurn(FirstTurn.COMPUTER)
                .withMatchesInStack(13)
                .withStrategy(Strategy.WIN)
                .build();
        GameService gameService = mock(GameService.class);
        MatchesToTakeValidator validator = new MatchesToTakeValidator(gameService);
        when(gameService.loadGame()).thenReturn(game);
        assertTrue(validator.isValid(2, null));
    }

    @Test
    void invalidMove() {
        Game game = GameBuilder.aGame()
                .withFirstTurn(FirstTurn.COMPUTER)
                .withMatchesInStack(2)
                .withStrategy(Strategy.WIN)
                .build();
        GameService gameService = mock(GameService.class);
        MatchesToTakeValidator validator = new MatchesToTakeValidator(gameService);
        when(gameService.loadGame()).thenReturn(game);
        assertFalse(validator.isValid(3, null));
    }

}
