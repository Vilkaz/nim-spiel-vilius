package de.holisticon.nimgamevilius.model;

/**
 * Contains starting settings for a game.
 *
 * Partially gotten from the player, partially from the System default values.
 */
public class Settings {

    private Strategy strategy;
    private FirstTurn firstTurn;

    private int startingMatchesAmount;

    public Settings(GameStarter gameStarter, Integer startingMatchesAmount) {
        strategy = gameStarter.getStrategy();
        firstTurn = gameStarter.getFirstTurn();
        this.startingMatchesAmount = startingMatchesAmount;
    }

    Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    FirstTurn getFirstTurn() {
        return firstTurn;
    }

    public void setFirstTurn(FirstTurn firstTurn) {
        this.firstTurn = firstTurn;
    }

    int getStartingMatchesAmount() {
        return startingMatchesAmount;
    }

    public void setStartingMatchesAmount(int startingMatchesAmount) {
        this.startingMatchesAmount = startingMatchesAmount;
    }

}
