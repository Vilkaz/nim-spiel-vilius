package de.holisticon.nimgamevilius.model;

public class GameHandler {

    private static Game game;

    public static Game startNewGame(Settings settings) {
        game = new Game(settings);
        return game;
    }

    public static Game getGame() {
        return game;
    }
}
