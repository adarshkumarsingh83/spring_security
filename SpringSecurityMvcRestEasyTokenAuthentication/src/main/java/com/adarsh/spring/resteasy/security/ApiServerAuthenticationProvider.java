package com.adarsh.spring.resteasy.security;

/**
 * Created by Adarsh on 3/15/15.
 */


import com.adarsh.spring.resteasy.persistance.entity.Role;
import com.adarsh.spring.resteasy.persistance.entity.User;
import com.adarsh.spring.resteasy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
@Service
public class ApiServerAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private static final Logger LOG = LoggerFactory.getLogger(ApiServerAuthenticationProvider.class);

    @Autowired
    private UserService userService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
        final String userName=userDetails.getUsername();
        final String userPwd=userDetails.getPassword();
        final User user = userService.getUser(userName);
        if(user == null ) {
            throw new BadCredentialsException("Username not found");
        }
        if(!user.getPassword().equals(userPwd)){
            throw new BadCredentialsException("Username Password Not Matched");
        }
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
        final User user = userService.getUser(username);
        LOG.debug("Inside-ApiServerAuthenticationProvider.java");

        if(user == null) {
            throw new BadCredentialsException("Username not found");
        }

        final Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        final Role role = user.getRole();
        if (role !=null) {
                authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),authorities);
    }
    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
