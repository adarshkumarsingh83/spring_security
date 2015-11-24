package com.adarsh.spring.rest.security;

/**
 * Created by Adarsh on 3/15/15.
 */

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityContextProvider {

    public SecurityContext getSecurityContext() {
        return SecurityContextHolder.getContext();
    }

}