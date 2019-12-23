package de.holisticon.nimgamevilius.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameHandlerTest {

    @Test
    void init() {
        Game game = GameHandler.startNewGame(new Settings(Strategy.WIN, FirstTurn.PLAYER));
        assertThat(game).isNotNull();
    }

}
