package com.adarsh.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Controller
public class ApplicationController {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);

    @RequestMapping(value = "/home.do", method = RequestMethod.GET)
    public ModelAndView home(ModelMap model, Principal principal) {
        logger.info("Request Received for Home page");
        String name = principal.getName();
        model.addAttribute("username", name);
        model.addAttribute("message", " Home Page");
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/superadmin/home.do", method = RequestMethod.GET)
    public String getSuperAdminHome(ModelMap model, Principal principal) {
        logger.info("Request Received for super admin page");
        String name = principal.getName();
        model.addAttribute("username", name);
        model.addAttribute("message", "Super Admin Home Page");
        return "superadmin/superAdminHome";
    }

    @RequestMapping(value = "/admin/home.do", method = RequestMethod.GET)
    public String getAdminHome(ModelMap model, Principal principal) {
        logger.info("Request Received for admin page");
        String name = principal.getName();
        model.addAttribute("username", name);
        model.addAttribute("message", "Admin Home Page");
        return "admin/adminHome";
    }

    @RequestMapping(value = "/user/home.do", method = RequestMethod.GET)
    public String getUserHome(ModelMap model, Principal principal) {
        logger.info("Request Received for user page");
        String name = principal.getName();
        model.addAttribute("username", name);
        model.addAttribute("message", "User Home Page");
        return "user/userHome";
    }

}