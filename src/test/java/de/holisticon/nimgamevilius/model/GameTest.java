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

        PlayersMove playersMove = new PlayersMove();
        playersMove.setMatchesToTake(1);
        game.calculatePlayersTurn(playersMove);
        assertThat(game.getMatchesInStack()).isEqualTo(9);
        playersMove.setMatchesToTake(2);
        game.calculatePlayersTurn(playersMove);
        assertThat(game.getMatchesInStack()).isEqualTo(5);
        playersMove.setMatchesToTake(3);
        game.calculatePlayersTurn(playersMove);
        assertThat(game.getMatchesInStack()).isEqualTo(1);

    }
}
