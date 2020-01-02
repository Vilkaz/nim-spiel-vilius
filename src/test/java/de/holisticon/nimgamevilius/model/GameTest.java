package de.holisticon.nimgamevilius.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    void removeValidAmountOfMatches() {
        Game game = GameBuilder.aGame()
                .withFirstTurn(FirstTurn.PLAYER)
                .withMatchesInStack(13)
                .withStrategy(Strategy.WIN)
                .build();

        game.handlePlayersTurn(1);
        assertThat(game.getMatchesInStack()).isEqualTo(9);
        game.handlePlayersTurn(2);
        assertThat(game.getMatchesInStack()).isEqualTo(5);
        game.handlePlayersTurn(3);
        assertThat(game.getMatchesInStack()).isEqualTo(1);
    }
}
