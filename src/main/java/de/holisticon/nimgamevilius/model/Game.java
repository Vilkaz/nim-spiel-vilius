package de.holisticon.nimgamevilius.model;

public class Game {
    private int matchesInStack;
    private String message;
    private Settings settings;

    private Game() {
        // no initialisation
    }

    Game(Settings settings) {
        this.settings = settings;
        matchesInStack = 13;
    }


    public int getMatchesInStack() {
        return matchesInStack;
    }

    public String getMessage() {
        return message;
    }

    public Settings getSettings() {
        return settings;
    }
}
