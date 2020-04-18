package com.espark.adarsh.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApplicationController {

    @GetMapping("/message")
    @PreAuthorize("hasAuthority('READ')")
    public String getMessage() {
        return "WELCOME TO  THE ESAPRK";
    }
}
