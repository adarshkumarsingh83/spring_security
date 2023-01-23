package com.espark.adarsh.web;

import com.espark.adarsh.bean.UserCredential;
import com.espark.adarsh.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/token")
    public String generateToken(@RequestBody UserCredential userCredential){
        return this.authenticationService.authenticateAndGenerateToken(userCredential);
    }
}
