package com.adarsh.spring.rest.security;


import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
public class RestLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request
            , HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        response.addHeader("MESSAGE","LOGOUT-SUCCESS");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}