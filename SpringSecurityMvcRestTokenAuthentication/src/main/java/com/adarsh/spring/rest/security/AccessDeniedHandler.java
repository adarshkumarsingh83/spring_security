package com.adarsh.spring.rest.security;

import org.springframework.security.access.AccessDeniedException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
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
