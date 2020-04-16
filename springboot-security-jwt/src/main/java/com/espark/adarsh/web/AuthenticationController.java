package com.espark.adarsh.web;

import com.espark.adarsh.bean.AuthenticationRequestBean;
import com.espark.adarsh.bean.AuthenticationResponseBean;
import com.espark.adarsh.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseBean> authenticateAndGenerateToken(@RequestBody AuthenticationRequestBean requestBean) {
        log.info("label=authenticateAndGenerateToken() execution");
        if (this.authenticationService.authenticateUser(requestBean.getUserName(), requestBean.getUserPwd())) {
            return ResponseEntity.ok(this.authenticationService.generateToken(requestBean.getUserName()));
        }
        throw new BadCredentialsException("Invalid User & Pwd ");
    }

}
