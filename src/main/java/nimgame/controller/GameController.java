package nimgame.controller;

import nimgame.model.Game;
import nimgame.model.GameStarter;
import nimgame.model.PlayersMove;
import nimgame.service.GameService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Access point for the Rest communication.
 *
 */
@RestController()
@RequestMapping("api")
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/start")
    public Game start(@Valid @RequestBody GameStarter gameStarter) {
        return gameService.startNewGame(gameStarter);

    }

    @PostMapping("/play")
    public Game play(@Valid @RequestBody PlayersMove playersMove) {
        return gameService.play(playersMove);
    }

    @GetMapping("/status")
    public Game status() {
        return gameService.loadGame();
    }

}
