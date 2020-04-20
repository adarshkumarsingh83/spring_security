package com.espark.adarsh.config;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OAuthWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

}
