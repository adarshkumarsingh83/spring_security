package com.adarsh.spring.resteasy.rest;

import com.adarsh.spring.resteasy.bean.UserBean;
import com.adarsh.spring.resteasy.persistance.entity.User;
import com.adarsh.spring.resteasy.service.UserService;
import com.adarsh.spring.resteasy.util.SpringRestApplicationContext;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
public class RestWebService {

    //http://localhost:8080/SpringSecurityRestEasy/rest/users/list

    @GET
    @Path("/list")
    @Produces("application/json")
    public Response printMessage(@Context HttpServletResponse httpServletResponse) {
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON);
        UserService userService = (UserService) SpringRestApplicationContext.getBean(UserService.class);
        final List<User> userList = userService.getUser();
        return Response.status(200).entity(UserBean.getUserBeanList(userList)).build();
    }
}