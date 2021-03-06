/*
 * Copyright (c) 2015 Espark And ©Adarsh Development Services @copyright All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Espark nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
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
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
@Controller
public class ApplicationController {

    private static final Logger logger = LoggerFactory.getLogger("ApplicationController");

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