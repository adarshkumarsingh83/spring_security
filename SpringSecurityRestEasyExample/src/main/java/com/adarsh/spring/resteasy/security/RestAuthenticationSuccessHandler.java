package com.adarsh.spring.resteasy.security;

/**
 * Created by Adarsh on 4/30/15.
 */

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Authentication success handler for REST services
 */
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.addHeader("MESSAGE", "AUTHENTICATION-SUCCESS");
        response.addHeader("LOGIN-MESSAGE","LOGIN-SUCCESS") ;
        // response.addHeader("JSESSIONID",request.getSession(false).getId()) ;
        clearAuthenticationAttributes(request);
    }
}