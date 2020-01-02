package de.holisticon.nimgamevilius.model;

import javax.validation.constraints.NotNull;

/**
 * An DTO Class for start the game. Has to contain the needed values.
 */
public class GameStarter {
    @NotNull(message = "Please enter Strategy for Computer. Keyword = \"strategy\" possible values = \"RANDOM\", \"WIN\"")
    private Strategy strategy;
    @NotNull(message = "Please enter who got first turn. Key = \"firstTurn\" possible values = \"COMPUTER\", \"PLAYER\"")
    private FirstTurn firstTurn;

    /**
     * For tests
     */
    public GameStarter(Strategy strategy, FirstTurn firstTurn) {
        this.strategy = strategy;
        this.firstTurn = firstTurn;
    }

    FirstTurn getFirstTurn() {
        return firstTurn;
    }

    public void setFirstTurn(FirstTurn firstTurn) {
        this.firstTurn = firstTurn;
    }

    Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
