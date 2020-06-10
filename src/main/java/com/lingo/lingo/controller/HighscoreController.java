package com.lingo.lingo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HighscoreController {
    @GetMapping("/highscore")
    public String test() {
        return "highscore";
    }
}
