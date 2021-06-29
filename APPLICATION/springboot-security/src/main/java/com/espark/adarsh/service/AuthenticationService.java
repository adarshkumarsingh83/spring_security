package com.espark.adarsh.service;

import com.espark.adarsh.bean.AuthenticationResponseBean;
import com.espark.adarsh.bean.UserBean;
import com.espark.adarsh.exception.ApplicationException;
import com.espark.adarsh.util.JwtUtilService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthenticationService {

    @Autowired
    JwtUtilService jwtUtilService;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    /**
     * @param userName
     * @param userPwd
     * @return
     */
    public boolean authenticateUser(String userName, String userPwd) throws AuthenticationException {
        log.info("label=authenticateUser execution");
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(userName, userPwd);
        Authentication authentication = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        return authentication.isAuthenticated();
    }

    /**
     * @param userName
     * @return
     */
    public AuthenticationResponseBean generateToken(String userName) {
        log.info("label=generateToken execution");
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
        String token = this.jwtUtilService.generateToken(userDetails);
        UserBean userBean = this.userDetailsService.getUserDetailBean(userName);
        return new AuthenticationResponseBean("X-TOKEN: "+token,"Token for Authenticated User" , userBean);
    }

}
