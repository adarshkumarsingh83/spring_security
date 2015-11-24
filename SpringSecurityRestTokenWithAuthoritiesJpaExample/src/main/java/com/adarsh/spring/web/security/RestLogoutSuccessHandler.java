package com.adarsh.spring.web.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 1/1/13 00:11 AM#$
 */
public class RestLogoutSuccessHandler implements LogoutSuccessHandler {

    private static final Logger log = LoggerFactory.getLogger(RestLogoutSuccessHandler.class);
    @Override
    public void onLogoutSuccess(HttpServletRequest request
            , HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        log.info("RestLogoutSuccessHandler onLogoutSuccess()");
        response.addHeader("MESSAGE","LOGOUT-SUCCESS");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}