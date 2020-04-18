package com.espark.adarsh.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {

    @RequestMapping(value = "/")
    public String loadEsparkHomePage(){
        return "home";
    }

    @RequestMapping(value = "/secure")
    public String loadEsparkSecurePage(){
        return "secure";
    }

}
