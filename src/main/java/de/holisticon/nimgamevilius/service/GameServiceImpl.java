package de.holisticon.nimgamevilius.service;

import de.holisticon.nimgamevilius.model.Game;
import de.holisticon.nimgamevilius.model.GameHandler;
import de.holisticon.nimgamevilius.model.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService{

    @Value("${game.amountOfStartingMatches}")
    private Integer startingMatchesAmount;

    @Override
    public Game startNewGame(Settings settings) {
        settings.setStartingMatchesAmount(startingMatchesAmount);
        return GameHandler.startGame(settings);
    }

    @Override
    public Game play(int playerTookMatches) {
        return GameHandler.play(playerTookMatches);
    }

}
