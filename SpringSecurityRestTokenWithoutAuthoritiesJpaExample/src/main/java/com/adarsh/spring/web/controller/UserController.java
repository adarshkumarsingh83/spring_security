package com.adarsh.spring.web.controller;

import com.adarsh.spring.persistence.entity.User;
import com.adarsh.spring.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 1/1/13 00:11 AM#$
 */
@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired(required = true)
    private UserService userService;
    /*
        SERVICE URL=http://localhost:8080/SpringRestTokenSecurityJpaExmaple/api/user/all
    */
    //@Secured("ROLE_USER,ROLE_ADMIN")
    @RequestMapping(value = "/user/all",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    public
    @ResponseBody
    List<User> getAllUser() {
        log.info("UserController Get All User List Request ");
        return this.userService.getAllUser();
    }
}
