package de.holisticon.nimgamevilius.model;

public class Response {
    private Game game;
    private String message;

    public Response(Game game, String message) {
        this.game = game;
        this.message = message;
    }

    public Game getGame() {
        return game;
    }

    public String getMessage() {
        return message;
    }
}
