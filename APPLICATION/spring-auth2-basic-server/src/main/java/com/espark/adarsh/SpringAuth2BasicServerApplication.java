package com.espark.adarsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;


@SpringBootApplication
@EnableAuthorizationServer
public class SpringAuth2BasicServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAuth2BasicServerApplication.class, args);
	}

}
