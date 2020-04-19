package com.espark.adarsh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Order(-100)
@Configuration
@EnableWebSecurity
public class FacebookOAuthSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
             http.csrf()
                .disable()
                .antMatcher("/api/**")
                .authorizeRequests()
                .antMatchers("/", "/login**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/").permitAll();
    }
}
