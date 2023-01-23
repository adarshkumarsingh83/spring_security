package com.espark.adarsh.web;

import com.espark.adarsh.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApplicationController {

    @Autowired
    WishService wishService;

    @GetMapping("/wish/{name}")
    public ResponseEntity<Map<String, String>> wish(@PathVariable("name") String name) {
        return ResponseEntity.ok(wishService.wish(name));
    }

    @RequestMapping("/access-denied")
    public ResponseEntity<Map<String, String>> accessDenied() {
        return ResponseEntity.ok(new HashMap<String, String>() {
            {
                put("message", "Not Allowed to Access ");
            }
        });
    }

}
