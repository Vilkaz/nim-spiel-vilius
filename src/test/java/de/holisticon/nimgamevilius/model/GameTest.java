package de.holisticon.nimgamevilius.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {


    @Test
    public void removeValidAmountOfMatches() {
        Game game = GameBuilder.aGame()
                .withFirstTurn(FirstTurn.PLAYER)
                .withMatchesInStack(13)
                .withStrategy(Strategy.RANDOM)
                .build();

        game.reduceMatches(1);
        assertThat(game.getMatchesInStack()).isEqualTo(12);
        game.reduceMatches(2);
        assertThat(game.getMatchesInStack()).isEqualTo(10);
        game.reduceMatches(3);
        assertThat(game.getMatchesInStack()).isEqualTo(7);

    }
}
