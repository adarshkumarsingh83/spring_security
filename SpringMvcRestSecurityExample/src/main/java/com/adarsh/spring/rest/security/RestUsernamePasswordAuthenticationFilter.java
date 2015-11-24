package com.adarsh.spring.rest.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Adarsh on 3/17/15.
 */
public class RestUsernamePasswordAuthenticationFilter extends
        UsernamePasswordAuthenticationFilter {

    private static final Logger LOG = LoggerFactory.getLogger(RestUsernamePasswordAuthenticationFilter.class);

    @Override
    protected void successfulAuthentication(HttpServletRequest request,HttpServletResponse response
            , FilterChain chain, Authentication authResult)throws IOException, ServletException {
        LOG.info("==successful login==");
        super.successfulAuthentication(request, response,chain, authResult);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response, AuthenticationException failed)
            throws IOException, ServletException {
        LOG.info("==failed login==");
        super.unsuccessfulAuthentication(request, response, failed);
    }

}