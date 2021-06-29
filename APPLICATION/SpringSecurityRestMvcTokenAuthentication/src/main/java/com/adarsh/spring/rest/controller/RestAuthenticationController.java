/*
 * Copyright (c) 2015 Espark And ©Adarsh Development Services @copyright All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Espark nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.adarsh.spring.rest.controller;

import com.adarsh.spring.rest.bean.ApiServer;
import com.adarsh.spring.rest.entity.User;
import com.adarsh.spring.rest.security.SecurityContextProvider;
import com.adarsh.spring.rest.security.TokenProvider;
import com.adarsh.spring.rest.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
@Controller
public class RestAuthenticationController {
    private static final Logger logger = LoggerFactory.getLogger(RestAuthenticationController.class);

    @Autowired(required = true)
    private UserService userService;

    @Autowired(required = true)
    private TokenProvider tokenProvider;

    private final String STATUS = "failure";
    private final String MESSAGE = "Invalid Username or Password";
    private final String USERNAME = "username";
    private final String PASSWORD = "password";

    @Autowired(required = true)
    private AuthenticationManager authenticationManager;

    private SecurityContextProvider securityContextProvider = new SecurityContextProvider();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public
    @ResponseBody
    ApiServer authenticate(@RequestBody Map<String, String> map, HttpServletResponse httpServletResponse) {
        final ApiServer apiServer = new ApiServer();
        logger.debug("Inside-AuthenticationController.java");

        String token = null;
        final String username = map.get(USERNAME);
        final String password = map.get(PASSWORD);
        User user = null;
        try {
            user = userService.getUser(username, password);
        } catch (Exception e) {
            logger.error("User Name Or Password Not Found");
            apiServer.setMessage("LOGIN UNSUCCESSFUL ");
            apiServer.setHttpStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return apiServer;
        }

        if (user != null) {
            final UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
            final boolean result = this.authenticationManager.authenticate(authentication).isAuthenticated();

            if (result) {
                user = new User();
                user.setUserName(username);
                user.setPassword(password);
            }
        }

        if (user != null) {
            token = tokenProvider.getToken(user);
            httpServletResponse.setHeader("Authentication-token", token);
            apiServer.setToken(token);
            apiServer.setUserName(username);
            apiServer.setUserPassword(password);
            apiServer.setMessage("LOGIN SUCCESSFUL ");
            apiServer.setHttpStatus(HttpServletResponse.SC_OK);
        } else {
            apiServer.setMessage("LOGIN UNSUCCESSFUL ");
            apiServer.setHttpStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
        return apiServer;
    }
}