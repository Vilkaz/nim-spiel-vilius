package de.holisticon.nimgamevilius.model;

import de.holisticon.nimgamevilius.common.Translator;

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
                .withMessage(Translator.getText("game.new-game-started"))
                .build();

       return game;
    }

    public static Game play(int playerTookMatches) {
        game.calculatePlayersTurn(playerTookMatches);
        return game;
    }

    public static Game status() {
        return game;
    }
}
