package de.holisticon.nimgamevilius.model;

import java.util.function.Consumer;

public enum FirstTurn {

    /**
     * If player starts first, make no first turn
     */
    PLAYER(g -> {}),

    /**
     * If computer makes first turn, make a move
     */
    COMPUTER(Game::makeMove);

    private Consumer<Game> makeFirstTurn;

    FirstTurn(Consumer<Game> makeFirstTurn) {
        this.makeFirstTurn = makeFirstTurn;
    }

    public void makeFirstTurn(Game game) {
        makeFirstTurn.accept(game);
    }
}
