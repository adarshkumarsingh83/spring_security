package com.espark.adarsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ApplicationZuulServer {

    public static void main(String[] args) {

        SpringApplication.run(ApplicationZuulServer.class, args);
    }
}
