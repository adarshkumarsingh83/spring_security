package com.espark.adarsh.service;

import com.espark.adarsh.persistance.entity.User;
import com.espark.adarsh.persistance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service(value = "userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String input) {
        User user = userRepository.findByUsername(input);
        if (user == null)
            throw new BadCredentialsException("Bad credentials");
        new AccountStatusUserDetailsChecker().check(user);
        return user;
    }
}
