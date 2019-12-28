package de.holisticon.nimgamevilius.model;

import javax.validation.constraints.NotNull;


/**
 * Contains starting settings for a game.
 *
 * Partially gotten from the player, partially from the System default values.
 */
public class Settings {

    public Settings(Strategy strategy, FirstTurn firstTurn) {
        this.strategy = strategy;
        this.firstTurn = firstTurn;
    }

    @NotNull(message = "Please enter Strategy for Computer. Keyword = \"strategy\" possible values = \"RANDOM\", \"WIN\"")
    private Strategy strategy;
    @NotNull(message = "Please enter who got first turn. Key = \"firstTurn\" possible values = \"COMPUTER\", \"PLAYER\"")
    private FirstTurn firstTurn;

    private int startingMatchesAmount;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public FirstTurn getFirstTurn() {
        return firstTurn;
    }

    public void setFirstTurn(FirstTurn firstTurn) {
        this.firstTurn = firstTurn;
    }

    public int getStartingMatchesAmount() {
        return startingMatchesAmount;
    }

    public void setStartingMatchesAmount(int startingMatchesAmount) {
        this.startingMatchesAmount = startingMatchesAmount;
    }

}
