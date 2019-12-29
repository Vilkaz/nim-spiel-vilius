package de.holisticon.nimgamevilius.model;

import de.holisticon.nimgamevilius.common.Translator;


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

    void calculatePlayersTurn(PlayersMove playersMove) {
        matchesInStack -= playersMove.getMatchesToTake();
        if (matchesInStack == 0) {
            message = Translator.getText("game.computer-wins");
        } else {
            makeMove();
        }
    }
}
