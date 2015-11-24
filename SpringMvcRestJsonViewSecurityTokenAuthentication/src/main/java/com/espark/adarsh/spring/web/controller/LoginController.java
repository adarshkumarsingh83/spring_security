package com.espark.adarsh.spring.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger("LoginController");

    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public ModelAndView login(ModelMap model) {
        logger.info("Request Received for Login page");
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/loginFailed.do", method = RequestMethod.GET)
    public ModelAndView loginError(ModelMap model) {
        model.addAttribute("error", "invalid credential");
        logger.info("Login failed");
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/logout.do", method = RequestMethod.GET)
    public ModelAndView logout(ModelMap model) {
        logger.info("Request Received for Logout page");
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/access.do", method = RequestMethod.GET)
    public ModelAndView accessProblem(ModelMap model, Principal principal) {
        String name = principal.getName();
        model.addAttribute("username", name);
        model.addAttribute("message", "INSUFFICIENT ACCESS PRIVILEGE ");
        logger.info("access denied ");
        return new ModelAndView("access");
    }

}