package nimgame.service;

import nimgame.model.Game;
import nimgame.model.GameStarter;
import nimgame.model.PlayersMove;

public interface GameService {
    Game startNewGame(GameStarter gameStarter);
    Game play(PlayersMove playersMove);
    Game loadGame();
    Game saveGame(Game game);
}
