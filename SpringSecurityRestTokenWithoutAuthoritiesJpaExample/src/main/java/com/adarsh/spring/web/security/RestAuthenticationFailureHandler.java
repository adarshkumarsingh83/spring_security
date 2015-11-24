package com.adarsh.spring.web.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 1/1/13 00:11 AM#$
 */
public class RestAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private static final Logger log = LoggerFactory.getLogger(RestAuthenticationFailureHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request
            , HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        log.info("RestAuthenticationFailureHandler onAuthenticationFailure()");
        response.addHeader("MESSAGE","AUTHENTICATION-NOT-SUCCESS");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Bad credentials");
    }
}