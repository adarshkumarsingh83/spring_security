package com.adarsh.spring.rest.controller;

/**
 * Created by Adarsh on 3/13/15.
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.adarsh.spring.rest.entity.User;
import com.adarsh.spring.rest.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RestController {

    private static final Logger logger = LoggerFactory.getLogger(RestController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public
    @ResponseBody
    List<User> list() {
        return this.userService.getUser();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, String> login() {
        final Map<String, String> map = new HashMap<String, String>();
        logger.info("Login Method Successful");
        map.put("Msg", "Login Successful");
        return map;
    }
}
