
package com.adarsh.spring.resteasy.rest;


import com.adarsh.spring.resteasy.bean.ApiServer;
import com.adarsh.spring.resteasy.persistance.entity.User;
import com.adarsh.spring.resteasy.security.SecurityContextProvider;
import com.adarsh.spring.resteasy.security.TokenProvider;
import com.adarsh.spring.resteasy.service.UserService;
import com.adarsh.spring.resteasy.util.SpringRestApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
@Path("/authenticate")
public class RestAuthenticationController {
    private static final Logger logger = LoggerFactory.getLogger(RestAuthenticationController.class);

    private UserService userService = (UserService) SpringRestApplicationContext.getBean(UserService.class);

    private UserDetailsService userDetailsService=(UserDetailsService)SpringRestApplicationContext.getBean(UserDetailsService.class);

    private TokenProvider tokenProvider=(TokenProvider)SpringRestApplicationContext.getBean(TokenProvider.class);

    private AuthenticationManager authenticationManager=(AuthenticationManager)SpringRestApplicationContext.getBean("authenticationManager");

    private SecurityContextProvider securityContextProvider = new SecurityContextProvider();

    private final String STATUS = "failure";
    private final String MESSAGE = "Invalid Username or Password";

    private final String USERNAME = "username";

    private final String PASSWORD = "password";

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticate(Map<String, String> map,@Context HttpServletResponse httpServletResponse) {
        final ApiServer apiServer = new ApiServer();
        logger.debug("Inside-AuthenticationController.java");

        String token = null;
        final String username = map.get(USERNAME);
        final String password = map.get(PASSWORD);
        User user = null;
        try {
            user = userService.getUser(username);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (user == null) {
            final UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
            final boolean result = this.authenticationManager.authenticate(authentication).isAuthenticated();
            if (result) {
                user = new User();
                user.setLogin(username);
                user.setPassword(password);
            }
        }


        if (user != null && user.getPassword().equals(password)) {
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
        return Response.status(200).entity(apiServer).build();
    }

}