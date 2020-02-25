package nimgame.repository;

import nimgame.model.Game;
import org.springframework.stereotype.Repository;

/**
 * This class is basically Database simulation for the Kata.
 * <p>
 * It has an instance of the Game class.
 * <p>
 * In real application i would use repository to fetch and store data to/from
 * database.
 */
@Repository
public class GameRepositoryImpl implements GameRepository {

    private static Game game;

    public Game saveGame(Game game) {
        GameRepositoryImpl.game = game;
        //Sometimes the Objects are getting IDs after save, so i return the saved Object
        return game;
    }

    @Override
    public Game loadGame() {
        return game;
    }

}
