package com.adarsh.spring.rest.controller;

import com.adarsh.spring.rest.entity.User;
import com.adarsh.spring.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
@Controller
public class RestApplicationController {

    @Autowired(required = true)
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET,produces={"application/json"})
    public @ResponseBody
    List<User> getAllUser(){
        return this.userService.getUserList();
    }


}
