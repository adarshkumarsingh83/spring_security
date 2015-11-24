package com.adarsh.spring.web.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 1/1/13 00:11 AM#$
 */
@Service
public class ApiServerAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final Logger log = LoggerFactory.getLogger(ApiServerAuthenticationEntryPoint.class);
    private static final String LOGIN_REQUEST_MESSAGE = "Unauthorized Please Log-In";

    @Override
    public void commence(HttpServletRequest request
            , HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        log.info("ApiServerAuthenticationEntryPoint commence()");
        response.addHeader("MESSAGE", "NOT-AUTHENTICATED-ACCESS-DENIED");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, LOGIN_REQUEST_MESSAGE);
    }
}
