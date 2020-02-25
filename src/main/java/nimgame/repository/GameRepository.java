package nimgame.repository;

import nimgame.model.Game;

public interface GameRepository {

    Game saveGame(Game game);

    /**
     * Here we would pass some kind of key, to get exact the needed
     * Game for the session, for example session ID.
     *
     * As for the Kata, we are only having one Game.
     */
    Game loadGame();

}
