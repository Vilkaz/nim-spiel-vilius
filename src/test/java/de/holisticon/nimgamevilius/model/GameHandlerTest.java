package de.holisticon.nimgamevilius.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameHandlerTest {

    @Test
    public void init() {
        Game game = GameHandler.startNewGame(new Settings(Strategy.WIN, WhoStarts.COMPUTER));
        assertThat(game).isNotNull();
    }

}
