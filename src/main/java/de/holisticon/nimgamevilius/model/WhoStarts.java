package de.holisticon.nimgamevilius.model;

import java.util.function.Consumer;

public enum WhoStarts {
    /**
     * If the player starts, then do nothing
     */
    PLAYER(g -> {}) {
    },
    /**
     * If Computer starts, make an move
     */
    COMPUTER(Game::makeMove);

    private Consumer<Game> firstTurn;

    WhoStarts(Consumer<Game> firstMove) {
        firstTurn = firstMove;
    }

    public void firstMove(Game game) {
        firstTurn.accept(game);
    }
}
