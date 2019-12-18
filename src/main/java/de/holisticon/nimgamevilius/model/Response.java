package de.holisticon.nimgamevilius.model;

public class Response {
    private Game game;
    private String message;

    public Response(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public String getMessage() {
        return message;
    }
}
