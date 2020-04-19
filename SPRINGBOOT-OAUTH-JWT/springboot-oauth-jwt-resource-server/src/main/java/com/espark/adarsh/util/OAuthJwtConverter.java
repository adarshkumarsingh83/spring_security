package com.espark.adarsh.util;

import java.util.Map;

import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;


@Component
public class OAuthJwtConverter extends DefaultAccessTokenConverter implements JwtAccessTokenConverterConfigurer {

    @Override
    public void configure(JwtAccessTokenConverter converter) {
        converter.setAccessTokenConverter(this);
    }

    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
        OAuth2Authentication auth = super.extractAuthentication(map);
        OAuthTokenMapperBean details = new OAuthTokenMapperBean();

        if (map.get("id") != null)
            details.setId(map.get("id").toString());

        if (map.get("email") != null)
            details.setUserName((String) map.get("email"));

        if (map.get("name") != null)
            details.setName((String) map.get("name"));

        details.setAuthorities(auth.getAuthorities());

        auth.setDetails(details);
        return auth;
    }

}