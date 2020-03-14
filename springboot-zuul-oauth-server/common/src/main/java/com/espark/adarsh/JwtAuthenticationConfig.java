package com.espark.adarsh;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

/**
 * Config JWT.
 * Only one property 'espark.security.jwt.secret' is mandatory.
 *
 */
@Getter
@ToString
public class JwtAuthenticationConfig {

    @Value("${espark.security.jwt.url:/login}")
    private String url;

    @Value("${espark.security.jwt.header:Authorization}")
    private String header;

    @Value("${espark.security.jwt.prefix:Bearer}")
    private String prefix;

    @Value("${espark.security.jwt.expiration:#{24*60*60}}")
    private int expiration; // default 24 hours

    @Value("${espark.security.jwt.secret}")
    private String secret;


}
