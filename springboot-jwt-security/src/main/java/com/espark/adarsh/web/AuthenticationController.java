package com.espark.adarsh.web;

import com.espark.adarsh.security.model.AuthenticateRequest;
import com.espark.adarsh.security.model.JwtAuthenticationResponse;
import com.espark.adarsh.security.model.UserPrincipal;
import com.espark.adarsh.security.service.JWTTokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenProvider jwtTokenProvider;

    @PostMapping
    public ResponseEntity authenticateUser(@RequestBody AuthenticateRequest authenticateRequest) {
        Authentication authentication
                = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticateRequest.getUserName(),
                        authenticateRequest.getPassword()));
        String token = jwtTokenProvider.generateToken((UserPrincipal) authentication.getPrincipal());
        log.info("Token Created {}", token);
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }


}
