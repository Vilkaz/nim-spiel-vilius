package de.holisticon.nimgamevilius.controller;

import com.github.lambdaexpression.annotation.RequestBodyParam;
import de.holisticon.nimgamevilius.model.Game;
import de.holisticon.nimgamevilius.model.Settings;
import de.holisticon.nimgamevilius.service.GameService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/start")
    public Game start(@RequestBody Settings settings) {
        return gameService.startNewGame(settings);

    }


    @PostMapping("/play")
    public Game play(@RequestBodyParam Integer matchesToTake) {
        return gameService.play(matchesToTake);
    }



//    @ExceptionHandler(RuntimeException.class)
//    public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
//        return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

}
