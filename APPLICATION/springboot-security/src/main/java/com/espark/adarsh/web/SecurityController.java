package com.espark.adarsh.web;

import com.espark.adarsh.bean.ApiResponseBean;
import com.espark.adarsh.bean.AuthenticationRequestBean;
import com.espark.adarsh.bean.AuthenticationResponseBean;
import com.espark.adarsh.bean.UserBean;
import com.espark.adarsh.service.AuthenticationService;
import com.espark.adarsh.service.SecurityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class SecurityController {

    @Autowired
    SecurityService securityService;

    @Autowired
    AuthenticationService authenticationService;


    @PostMapping("/login")
    public ResponseEntity<ApiResponseBean<AuthenticationResponseBean>> authenticateAndGenerateToken(@RequestBody AuthenticationRequestBean requestBean) {
        log.info("label=authenticateAndGenerateToken() execution");
        if (this.authenticationService.authenticateUser(requestBean.getUserName(), requestBean.getUserPwd())) {
            return ResponseEntity.ok(new ApiResponseBean<AuthenticationResponseBean>(this.authenticationService.generateToken(requestBean.getUserName()), "token generated", null));
        }
        throw new BadCredentialsException("Invalid User & Pwd ");
    }

    @GetMapping("/user/{user-name}")
    public ApiResponseBean<UserBean> getUserDetails(@PathVariable("user-name") String userName) {
        ApiResponseBean<UserBean> apiResponseBean = new ApiResponseBean<>();
        apiResponseBean.setData(this.securityService.getUserDetails(userName));
        apiResponseBean.setMessage("User Details");
        return apiResponseBean;
    }

}
