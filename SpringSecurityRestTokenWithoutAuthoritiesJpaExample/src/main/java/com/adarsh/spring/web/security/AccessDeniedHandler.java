package com.adarsh.spring.web.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 1/1/13 00:11 AM#$
 */
public class AccessDeniedHandler implements
        org.springframework.security.web.access.AccessDeniedHandler {

    private static final Logger log = LoggerFactory.getLogger(AccessDeniedHandler.class);

    @Override
    public void handle(HttpServletRequest request
            , HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        log.info("AccessDeniedHandler handle method() ");
        response.addHeader("MESSAGE","AUTHENTICATION-NOT-SUCCESS");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Bad credentials");
    }
}
