package com.adarsh.spring.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
@Service
public class ApiServerAuthenticationEntryPoint implements AuthenticationEntryPoint {


    private static final String FAILURE = "failure";
    private static final String LOGIN_REQUEST_MESSAGE = "Please log in";


    @Override
    public void commence(HttpServletRequest request
            , HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {

        response.addHeader("MESSAGE", "NOT-AUTHENTICATED-ACCESS-DENIED");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
}
