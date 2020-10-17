package com.espark.adarsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SecurityService securityService;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        com.espark.adarsh.entity.User findUser = this.securityService.findUserByName(userName);
        if (findUser != null) {
            List<SimpleGrantedAuthority> userRoles = findUser.getRoles()
                    .stream()
                    .map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
            return new User(findUser.getUserName(), findUser.getPassword(), userRoles);
        }
        throw new UsernameNotFoundException("User Not Found for name" + userName);
    }
}
