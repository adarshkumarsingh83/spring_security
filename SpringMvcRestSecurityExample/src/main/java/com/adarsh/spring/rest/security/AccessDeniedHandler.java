package com.adarsh.spring.rest.security;

import org.springframework.security.access.AccessDeniedException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Adarsh on 3/15/15.
 */
public class AccessDeniedHandler implements
        org.springframework.security.web.access.AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request
            , HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        response.addHeader("MESSAGE","AUTHENTICATION-NOT-SUCCESS");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Bad credentials");
    }
}
