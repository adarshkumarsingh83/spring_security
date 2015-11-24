package com.adarsh.spring.security;

/**
 * Created by Adarsh on 3/13/15.
 */

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RestAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request
            , HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        response.addHeader("MESSAGE","AUTHENTICATION-NOT-SUCCESS");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Bad credentials");
    }
}