package com.espark.adarsh.web;

import com.espark.adarsh.service.IntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {

    @Autowired
    private IntegrationService integrationService;

    @RequestMapping(value = "/")
    public String loadEsparkHomePage() {
        return "home";
    }

    @RequestMapping(value = {"/secure", "/employee"})
    public String loadEsparkSecurePage(Model model) {
        this.integrationService.getEmployees(model);
        return "secure";
    }


}
