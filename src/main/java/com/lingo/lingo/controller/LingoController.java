package com.lingo.lingo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LingoController {
    @GetMapping("/lingo")
    public String test() {
        return "lingo";
    }
}
