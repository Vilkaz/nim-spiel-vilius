package de.holisticon.nimgamevilius.model;

import de.holisticon.nimgamevilius.common.Translator;

/**
 * The actual game. We are giving this as response to the player,
 * with all fields as information.
 */
public class Game {
    private int matchesInStack;
    private String message;
    private Strategy strategy;

    Game() {
        // package private
    }

    public int getMatchesInStack() {
        return matchesInStack;
    }

    public String getMessage() {
        return message;
    }

    /**
     * If we got here, then the players move was valid
     * and he did not won yet.
     */
    void makeMove() {
        Integer matchesToTake = strategy.calculateMatchesToTake(matchesInStack);
        matchesInStack -= matchesToTake;
        message = Translator.getText("game.took-amount-of-matches") + matchesToTake;
        if (matchesInStack == 0) {
            message += Translator.getText("game.player-wins");
        }
    }

    public Strategy getStrategy() {
        return strategy;
    }

    void setMatchesInStack(int matchesInStack) {
        this.matchesInStack = matchesInStack;
    }

    void setMessage(String message) {
        this.message = message;
    }

    void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }


    /**
     * Did the player won or do we have to make our own Move ?
     *
     * This will be decided here
     */
    void handlePlayersTurn(Integer matchesPlayerTook) {
        matchesInStack -= matchesPlayerTook;
        if (matchesInStack == 0) {
            message = Translator.getText("game.computer-wins");
        } else {
            makeMove();
        }
    }

}
