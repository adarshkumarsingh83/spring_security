package com.adarsh.spring.rest.security;

import com.adarsh.spring.rest.service.UniqueKeyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UniqueKeyService uniqueKeyService;

    private static final String FAILURE = "failure";
    private static final String LOGIN_REQUEST_MESSAGE = "Please log in";


    @Override
    public void commence(HttpServletRequest request
            , HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {

        final String uniqueKey = uniqueKeyService.generateUniqueId();
        response.addHeader("MESSAGE", "NOT-AUTHENTICATED-ACCESS-DENIED");
        response.addHeader("KEY", uniqueKey);
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
}
