package de.holisticon.nimgamevilius.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GameTest {

    private int amountOfStartigMatches = 13;

    @Test
    public void GameStarterConstructor() {
        Settings settings = new Settings(Strategy.RANDOM, WhoStarts.PLAYER);
        Game game = new Game(settings);
        assertThat(game.getMatchesInStack())
                  .isEqualTo(amountOfStartigMatches);
        assertThat(game.getSettings())
                  .isEqualTo(settings);
    }

}
