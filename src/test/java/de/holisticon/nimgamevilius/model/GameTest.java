package de.holisticon.nimgamevilius.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameTest {

    private int amountOfStartigMatches = 13;

    @Test
    void GameStarterConstructor() {
        Settings settings = new Settings(Strategy.RANDOM, FirstTurn.PLAYER);
        Game game = new Game(settings);
        assertThat(game.getMatchesInStack())
                  .isEqualTo(amountOfStartigMatches);
        assertThat(game.getSettings())
                  .isEqualTo(settings);
    }

}
