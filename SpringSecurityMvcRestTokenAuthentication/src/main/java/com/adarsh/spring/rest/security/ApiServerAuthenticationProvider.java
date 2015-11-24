package com.adarsh.spring.rest.security;

/**
 * Created by Adarsh on 3/15/15.
 */

import com.adarsh.spring.rest.entity.Permission;
import com.adarsh.spring.rest.entity.User;
import com.adarsh.spring.rest.service.UserService;
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
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
@Service
public class ApiServerAuthenticationProvider extends  AbstractUserDetailsAuthenticationProvider {

    private static final Logger LOG = LoggerFactory.getLogger(ApiServerAuthenticationProvider.class);

    @Autowired
    private UserService userService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
        final String userName=userDetails.getUsername();
        final String userPwd=userDetails.getPassword();
        final User user = userService.getUser(userName,userPwd);
        if(user == null ) {
            throw new BadCredentialsException("Username not found");
        }
        if(!user.getPassword().equals(userPwd)){
            throw new BadCredentialsException("User Password Doesn't Match");
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
        final Set<Permission> permissionsSet = user.getPermissionsSet();
        if (!CollectionUtils.isEmpty(permissionsSet)) {
            for (Permission permission : permissionsSet) {
                LOG.debug("PermissionName-{}",permission);
                authorities.add(new SimpleGrantedAuthority(permission.getPermissionName()));

            }
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),authorities);
    }
    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
