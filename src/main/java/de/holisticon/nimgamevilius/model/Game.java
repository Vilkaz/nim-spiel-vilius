package de.holisticon.nimgamevilius.model;

public class Game {
    private int matchesInStack;
    private String message;
    private Settings settings;

    private Game() {
        // no initialisation
    }

    /**
     * Starts a new Round of game.
     * Initialises the default values
     * Makes first Move if Computer Starts first
     *
     * @param settings Setting for the Game
     */
    Game(Settings settings) {
        this.settings = settings;
        matchesInStack = DefaultValues.AMOUNT_OF_STARTING_MATCHES.getInteger();
    }

    int getMatchesInStack() {
        return matchesInStack;
    }

    public String getMessage() {
        return message;
    }

    Settings getSettings() {
        return settings;
    }

    void makeMove() {
        matchesInStack -= settings
                .getStrategy()
                .calculateMatchesToTake(matchesInStack);
    }
}
