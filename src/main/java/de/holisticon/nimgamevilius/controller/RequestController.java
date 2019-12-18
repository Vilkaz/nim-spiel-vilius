package de.holisticon.nimgamevilius.controller;

import de.holisticon.nimgamevilius.model.Game;
import de.holisticon.nimgamevilius.model.GameHandler;
import de.holisticon.nimgamevilius.model.Response;
import de.holisticon.nimgamevilius.model.Settings;
import org.springframework.web.bind.annotation.*;

/**
 * Access point for the Rest communication.
 */
@RestController()
@RequestMapping("api")
public class RequestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/start")
    public Response play(@RequestBody Settings starter) {
        Game game = GameHandler.startNewGame(starter);
        return new Response(game);
    }

}
