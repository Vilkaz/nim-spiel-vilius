package de.holisticon.nimgamevilius.controller;

import de.holisticon.nimgamevilius.model.Game;
import org.springframework.web.bind.annotation.*;

/**
 * Access point for the Rest communication.
 */
@RestController()
@RequestMapping("api")
public class RequestController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @RequestMapping("/start")
    public Game play() {
        return new Game();
    }

}
