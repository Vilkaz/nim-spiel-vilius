package de.holisticon.nimgamevilius.model;

public class Game {
    private static final int STARTING_MATCHES_AMOUNT = 13;
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
        matchesInStack = STARTING_MATCHES_AMOUNT;
        settings.getWhoStarts()
                .firstMove(this);
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
