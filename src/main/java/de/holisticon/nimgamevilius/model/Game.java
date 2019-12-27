package de.holisticon.nimgamevilius.model;

public class Game {
    private int matchesInStack;
    private String message;
    private Strategy strategy;

    Game() {
        // package private
    }

    /**
     * Starts a new Round of game.
     * Initialises the default values
     * Makes first Move if Computer Starts first
     */
    Game(Strategy strategy, int startingMatchesAmount) {
        this.strategy = strategy;
        matchesInStack = startingMatchesAmount;
    }


    public int getMatchesInStack() {
        return matchesInStack;
    }

    public String getMessage() {
        return message;
    }

    void makeMove() {
        if (matchesInStack == 0) {
            message ="You took the last match, Computer has won !";
        } else {
            Integer matchesToTake = strategy.calculateMatchesToTake(matchesInStack);
            matchesInStack -= matchesToTake;
            message = "Computer took this amount of matches : " + matchesToTake;
            if (matchesInStack == 0) {
                message += "You have won ";
            }
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

    void calculatePlayersTurn(int reduceMatchesBy) {
        boolean valid = true;
        if (reduceMatchesBy > matchesInStack) {
            message = "You can't take more matches, then there are in game";
            valid = false;
        }
        if (reduceMatchesBy < 1 || reduceMatchesBy > 3) {
            message = "You can only pick minimal 1 and maximal 3 matches";
            valid = false;
        }

        if (valid) {
            matchesInStack -= reduceMatchesBy;
            makeMove();
        }

    }
}
