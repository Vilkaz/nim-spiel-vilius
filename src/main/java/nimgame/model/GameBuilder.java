package nimgame.model;

public final class GameBuilder {
    private int matchesInStack;
    private String message;
    private Strategy strategy;
    private FirstTurn firstTurn;

    private GameBuilder() {
    }

    public static GameBuilder aGame() {
        return new GameBuilder();
    }

    public GameBuilder withMatchesInStack(int matchesInStack) {
        this.matchesInStack = matchesInStack;
        return this;
    }

    public GameBuilder withMessage(String message) {
        this.message = message;
        return this;
    }

    public GameBuilder withStrategy(Strategy strategy) {
        this.strategy = strategy;
        return this;
    }


    public GameBuilder withFirstTurn(FirstTurn firstTurn) {
        this.firstTurn = firstTurn;
        return this;
    }



    public Game build() {
        Game game = new Game();
        game.setMatchesInStack(matchesInStack);
        game.setMessage(message);
        game.setStrategy(strategy);
        firstTurn.makeFirstTurn(game);
        return game;
    }
}
