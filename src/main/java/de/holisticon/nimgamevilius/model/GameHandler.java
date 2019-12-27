package de.holisticon.nimgamevilius.model;

/**
 * Class for Singleton instance of the Game class.
 *
 * In real application i would use repository to fetch and store data to/from
 * database, here im simply using a singleton.
 */
public class GameHandler {

    private static Game game;

    private GameHandler() {
        //no initialisation
    }

    public static Game startGame(Settings settings) {
       game = GameBuilder.aGame()
                .withFirstTurn(settings.getFirstTurn())
                .withMatchesInStack(settings.getStartingMatchesAmount())
                .withStrategy(settings.getStrategy())
                .withMessage("New Game started")
                .build();

       return game;
    }

    public static Game play(int playerTookMatches) {
        game.reduceMatches(playerTookMatches);
        game.makeMove();
        return game;
    }

}
