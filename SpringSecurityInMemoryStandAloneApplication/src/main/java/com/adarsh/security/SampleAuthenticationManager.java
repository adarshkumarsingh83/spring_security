package com.adarsh.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */

public class SampleAuthenticationManager implements AuthenticationManager {

    static final List<GrantedAuthority> SUPERADMIN_AUTHORITIES = new ArrayList<GrantedAuthority>();
    static final List<GrantedAuthority> ADMIN_AUTHORITIES = new ArrayList<GrantedAuthority>();
    static final List<GrantedAuthority> USER_AUTHORITIES = new ArrayList<GrantedAuthority>();
    static final Map<String,Map<String,String>>usersRoles=new HashMap<String,Map<String,String>>();
    static {
        SUPERADMIN_AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_SUPERADMIN"));
        SUPERADMIN_AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        SUPERADMIN_AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
        ADMIN_AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        ADMIN_AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
        USER_AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        if (auth.getName().equals(auth.getCredentials())) {
            return new UsernamePasswordAuthenticationToken(auth.getName(),
                    auth.getCredentials(), USER_AUTHORITIES);
        }
        throw new BadCredentialsException("Bad Credentials");
    }
}
