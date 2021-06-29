package com.adarsh.spring.resteasy.security;

import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

        final Map<String,String> apiServer=new HashMap<>();
        apiServer.put("MESSAGE","AUTHENTICATION-NOT-SUCCESS BAD CREDENTIALS");
        apiServer.put("STATUS", "" + HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(new Gson().toJson(apiServer));
        response.addHeader("MESSAGE","AUTHENTICATION-NOT-SUCCESS BAD CREDENTIALS");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
