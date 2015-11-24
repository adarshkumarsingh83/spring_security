package com.adarsh.spring.resteasy.security;

/**
 * Created by Adarsh on 3/14/15.
 */


import com.adarsh.spring.resteasy.persistance.resporitory.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service(value = "userDetailsServiceImpl")
public class RestUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {

        final com.adarsh.spring.resteasy.persistance.entity.User domainUser = userDAO.getUser(login);

        final boolean enabled = true;
        final boolean accountNonExpired = true;
        final boolean credentialsNonExpired = true;
        final boolean accountNonLocked = true;

        return new User(
                domainUser.getLogin(),
                domainUser.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                this.getAuthorities(domainUser.getRole().getRole())
        );
    }

    public Collection<? extends GrantedAuthority> getAuthorities(String role) {
        final List<String> roles = new ArrayList<String>();
         roles.add(role);
        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String rol : roles) {
            authorities.add(new SimpleGrantedAuthority(rol));
        }
        return authorities;
    }

}