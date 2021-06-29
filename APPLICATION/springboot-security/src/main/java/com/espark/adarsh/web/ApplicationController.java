package com.espark.adarsh.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApplicationController {

    @GetMapping("/message")
    public String getMessage() {
        log.info("label=getMessage() execution");
        return "WELCOME TO THE ESPARK";
    }
}