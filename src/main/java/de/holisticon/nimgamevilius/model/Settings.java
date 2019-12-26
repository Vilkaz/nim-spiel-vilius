package de.holisticon.nimgamevilius.model;

import com.google.common.base.Objects;

public class Settings {


    public Settings(Strategy strategy, FirstTurn firstTurn) {
        this.strategy = strategy;
        this.firstTurn = firstTurn;
    }

    private Strategy strategy;
    private FirstTurn firstTurn;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Settings settings = (Settings) o;
        return strategy == settings.strategy &&
                firstTurn == settings.firstTurn;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(strategy, firstTurn);
    }
}
