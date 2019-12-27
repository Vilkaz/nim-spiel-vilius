package de.holisticon.nimgamevilius.service;

import de.holisticon.nimgamevilius.model.Game;
import de.holisticon.nimgamevilius.model.Settings;

public interface GameService {
    Game startNewGame(Settings settings);
    Game play(int playTookMatches);
    Game status();
}
