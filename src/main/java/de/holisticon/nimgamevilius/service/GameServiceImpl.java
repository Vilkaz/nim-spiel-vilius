package de.holisticon.nimgamevilius.service;

import de.holisticon.nimgamevilius.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService{

    @Value("${game.amountOfStartingMatches}")
    private Integer startingMatchesAmount;

    @Override
    public Game startNewGame(GameStarter gameStarter) {
        Settings settings= new Settings(gameStarter, startingMatchesAmount);
        settings.setStartingMatchesAmount(startingMatchesAmount);
        return GameHandler.startGame(settings);
    }

    @Override
    public Game play(PlayersMove playersMove) {
        return GameHandler.play(playersMove);
    }

    @Override
    public Game status() {
        return GameHandler.status();
    }

}
