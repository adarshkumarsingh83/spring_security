package com.adarsh.spring.resteasy.security;

/**
 * Created by Adarsh on 3/13/15.
 */
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RestLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request
            , HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        response.addHeader("MESSAGE","LOGOUT-SUCCESS");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}