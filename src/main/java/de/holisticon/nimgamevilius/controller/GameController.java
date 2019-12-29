package de.holisticon.nimgamevilius.controller;

import de.holisticon.nimgamevilius.model.Game;
import de.holisticon.nimgamevilius.model.PlayersMove;
import de.holisticon.nimgamevilius.model.Settings;
import de.holisticon.nimgamevilius.service.GameService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Access point for the Rest communication.
 */
@RestController()
@RequestMapping("api")
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/start")
    public Game start(@Valid @RequestBody Settings settings) {
        return gameService.startNewGame(settings);

    }


    @PostMapping("/play")
    public Game play(@Valid @RequestBody PlayersMove playersMove) {
        return gameService.play(playersMove);
    }

    @GetMapping("/status")
    public Game status() {
        return gameService.status();
    }

}
