package de.holisticon.nimgamevilius.model;

public class GameStarter {

    private Strategy strategy;
    private WhoStarts whoStarts;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public WhoStarts getWhoStarts() {
        return whoStarts;
    }

    public void setWhoStarts(WhoStarts whoStarts) {
        this.whoStarts = whoStarts;
    }
}
