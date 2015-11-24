package com.adarsh.spring.resteasy.security;


import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
public class SecurityContextProvider {

    public SecurityContext getSecurityContext() {
        return SecurityContextHolder.getContext();
    }

}