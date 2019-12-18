package de.holisticon.nimgamevilius.controller;

import de.holisticon.nimgamevilius.model.Game;
import de.holisticon.nimgamevilius.model.GameStarter;
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
    public Game play(@RequestBody GameStarter starter) {
        return new Game();
    }

}
