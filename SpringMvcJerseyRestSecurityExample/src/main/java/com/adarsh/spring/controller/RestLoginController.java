package com.adarsh.spring.controller;

/**
 * Created by Adarsh on 3/13/15.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
public class RestLoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, String> login() {
        final Map<String, String> map = new HashMap<String, String>();
        System.out.println("login method");
        map.put("msg", "login Successful");
        return map;
    }
}
