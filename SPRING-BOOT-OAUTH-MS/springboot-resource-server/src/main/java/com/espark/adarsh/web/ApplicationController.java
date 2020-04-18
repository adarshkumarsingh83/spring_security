package com.espark.adarsh.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApplicationController {

    @GetMapping("/message")
    public String getMessage() {
        return "WELCOME TO  THE ESAPRK";
    }
}
