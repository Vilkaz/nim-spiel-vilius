package de.holisticon.nimgamevilius.service;

import de.holisticon.nimgamevilius.model.Game;
import de.holisticon.nimgamevilius.model.GameStarter;
import de.holisticon.nimgamevilius.model.PlayersMove;

public interface GameService {
    Game startNewGame(GameStarter gameStarter);
    Game play(PlayersMove playersMove);
    Game status();
}
