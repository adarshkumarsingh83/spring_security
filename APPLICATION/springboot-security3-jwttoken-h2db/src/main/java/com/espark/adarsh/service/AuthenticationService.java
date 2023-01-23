package com.espark.adarsh.service;

import com.espark.adarsh.bean.UserCredential;
import com.espark.adarsh.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthenticationService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String authenticateAndGenerateToken(UserCredential userCredential) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userCredential.getUsername(), userCredential.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtUtil.generateToken(userCredential.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }

    }
}
