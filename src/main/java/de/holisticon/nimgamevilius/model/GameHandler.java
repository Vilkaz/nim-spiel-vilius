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

    public static Game play(PlayersMove playersMove) {
        //In this case i simply take the int value.
        //I just dont want to give the API entry 1::1.
        //Eventually we need to change API or game logic Model
        //here i would map it.
        game.handlePlayersTurn(playersMove.getMatchesToTake());
        return game;
    }

    public static Game status() {
        return game;
    }
}
