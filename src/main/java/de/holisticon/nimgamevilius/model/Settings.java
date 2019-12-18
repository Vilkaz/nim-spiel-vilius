package de.holisticon.nimgamevilius.model;

import com.google.common.base.Objects;

public class Settings {

    public Settings() {
    }

    public Settings(Strategy strategy, WhoStarts whoStarts) {
        this.strategy = strategy;
        this.whoStarts = whoStarts;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Settings settings = (Settings) o;
        return strategy == settings.strategy &&
                whoStarts == settings.whoStarts;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(strategy, whoStarts);
    }
}
