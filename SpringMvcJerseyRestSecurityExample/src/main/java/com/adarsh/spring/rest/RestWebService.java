package com.adarsh.spring.rest;

/**
 * Created by Adarsh on 4/30/15.
 */
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.adarsh.spring.bean.UserBean;
import com.adarsh.spring.persistance.entity.User;
import com.adarsh.spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;


@Path("/users")
@Service
@Scope("singleton")
public class RestWebService {

    @Autowired
    private UserService userService;

    @GET
    @Path("/list")
    @Produces("application/json")
    public Response userList() {
        final List<User> userList = this.userService.getUser();
        return Response.status(200).entity(UserBean.getUserBeanList(userList)).build();
    }
}
