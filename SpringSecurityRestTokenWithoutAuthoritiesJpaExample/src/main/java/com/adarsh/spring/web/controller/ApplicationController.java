package com.adarsh.spring.web.controller;

import com.adarsh.spring.persistence.entity.User;
import com.adarsh.spring.web.security.SecurityUserDetails;
import com.adarsh.spring.web.security.TokenAuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 1/1/13 00:11 AM#$
 */
@Controller
public class ApplicationController {

    private static final Logger log = LoggerFactory.getLogger(ApplicationController.class);

    @Autowired(required = true)
    private TokenAuthenticationService tokenAuthenticationService;

    @RequestMapping(value = "/welcomePage",method = RequestMethod.GET)
    public String welcomePage(){
        log.info("Application Controller Welcome Page Request");
        return "welcomePage";
    }

    /*
    SERVICE URL=http://localhost:8080/SpringRestTokenSecurityJpaExmaple/api/login
    {"username":"adarsh","password":"adarsh"}
    X-AUTH-TOKEN:<token value>
    */
    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            produces = {"application/json"})
    public
    @ResponseBody
    Map<String, String> getAllUser(ServletRequest servletRequest) {
        log.info("Application Controller Login Token Request");
        final String headerName = "X-AUTH-TOKEN";
        final Map<String, String> result = new HashMap<String, String>();
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            final UserDetails userDetails=(UserDetails)authentication.getDetails();
            final SecurityUserDetails securityUserDetails = new SecurityUserDetails(userDetails);
            final String token = tokenAuthenticationService.getAuthenticationToken(securityUserDetails.getUsername());
            result.put("User-Name",securityUserDetails.getUsername());
            result.put(headerName, token);
            result.put("Token-Expires-In-MillSecond",securityUserDetails.getExpires()+"");
        }
        return result;
    }
}
