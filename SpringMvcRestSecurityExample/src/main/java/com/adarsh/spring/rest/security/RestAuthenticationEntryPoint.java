package com.adarsh.spring.rest.security;

/**
 * Created by Adarsh on 3/13/15.
 */
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request
            , HttpServletResponse response, AuthenticationException e)
            throws IOException, ServletException {
        response.addHeader("MESSAGE","NOT-AUTHENTICATED-ACCESS-DENIED");
        response.sendError( HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized" );
    }
}