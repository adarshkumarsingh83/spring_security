package com.espark.adarsh.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApplicationController {

    @GetMapping("/wish/{name}")
    public Map<String, String> getWish(@PathVariable("name") String name) {
        return getMessage(name);
    }

    @GetMapping("/user/{name}")
    public Map<String, String> getUser(@PathVariable("name") String name) {
        Map<String, String> message =  getMessage(name);
        message.put("role","user");
        return message;
    }

    @GetMapping("/admin/{name}")
    public Map<String, String> getAdmin(@PathVariable("name") String name) {
        Map<String, String> message =  getMessage(name);
        message.put("role","admin");
        return message;
    }

    public Map<String, String> getMessage(String name) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String msg = " welcome to the espark " + name;
        int hour = localDateTime.getHour();
        if (hour >= 4 && hour < 12) {
            msg = " Good Morning " + msg;
        } else if (hour >= 12 && hour < 16) {
            msg = " Good Afternoon " + msg;
        } else {
            msg = " Good Evening " + msg;
        }
        final String finalMsg = msg;
        return new HashMap<>() {
            {
                put("msg", finalMsg);
            }
        };
    }
}
