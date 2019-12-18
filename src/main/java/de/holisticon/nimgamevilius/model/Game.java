package de.holisticon.nimgamevilius.model;

public class Game {
    private Strategy strategy;
    private int matchesInStack;
    private String message;

    public Strategy getStrategy() {
        return strategy;
    }

    public int getMatchesInStack() {
        return matchesInStack;
    }

    public String getMessage() {
        return message;
    }
}
