package com.espark.adarsh.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    private Map<String, User> userStore = new HashMap<>();

    @PostConstruct
    public void init() {
        if (userStore.isEmpty()) {
            userStore.put("adarsh", new User("adarsh", "adarsh", Arrays.asList(new SimpleGrantedAuthority("ADMIN"))));
            userStore.put("radha", new User("radha", "radha", Arrays.asList(new SimpleGrantedAuthority("ADMIN"))));
            userStore.put("user", new User("user", "user", Arrays.asList(new SimpleGrantedAuthority("USER"))));
        }
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return this.getUser(userName);
    }


    private User getUser(String userName) {
        if (userStore.containsKey(userName)) {
            return userStore.get(userName);
        } else {
            throw new UsernameNotFoundException("User Not Found for name" + userName);
        }
    }

}
