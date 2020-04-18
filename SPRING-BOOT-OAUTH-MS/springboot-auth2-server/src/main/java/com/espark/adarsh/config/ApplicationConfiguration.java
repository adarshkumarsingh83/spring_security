package com.espark.adarsh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationConfiguration extends GlobalAuthenticationConfigurerAdapter {


    @Value("${espark.oauth.user.username}")
    private String userDefaultName;


    @Value("${espark.oauth.user.password}")
    private String userDefaultPwd;


    @Value("${espark.oauth.user.permission}")
    private String userDefaultPermission;


    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(userDefaultName)
                .password(passwordEncoder.encode(userDefaultPwd))
                .roles(userDefaultPermission.split(","))
                .and()
                .withUser("user")
                .password(passwordEncoder.encode("user"))
                .roles("USER");
    }
}
