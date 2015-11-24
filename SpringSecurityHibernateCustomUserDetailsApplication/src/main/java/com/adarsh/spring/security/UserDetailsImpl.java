package com.adarsh.spring.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author Adarsh kumar
 * @author $LastChangedBy: Adarsh $
 * @version $Revision: 572 $, $Date:: 2012-03-08 10:26:09#$
 */
public class UserDetailsImpl extends User implements UserDetails {

    public UserDetailsImpl(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public UserDetailsImpl(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    private com.adarsh.spring.entity.impl.User user;


    public com.adarsh.spring.entity.impl.User getUser() {
        return user;
    }

    public void setUser(com.adarsh.spring.entity.impl.User user) {
        this.user = user;
    }
}

