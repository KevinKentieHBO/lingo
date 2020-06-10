package com.lingo.lingo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class frontScreenController {
    @GetMapping("/frontscreen")
    public String test() {
        return "frontScreen";
    }
}
