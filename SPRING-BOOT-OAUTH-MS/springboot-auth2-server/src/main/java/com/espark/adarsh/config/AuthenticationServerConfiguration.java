package com.espark.adarsh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;


@Configuration
public class AuthenticationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Value("${espark.oauth.clientId}")
    private String clientId;

    @Value("${espark.oauth.clientSecret}")
    private String clientSecret;

    @Value("${espark.oauth2.client.scope}")
    private String scopes;

    @Value("${espark.oauth2.authorization.check-token-access}")
    private String checkTokenAccess;

    @Value("${espark.oauth2.client.authorized-grant-types}")
    private String grantType;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
                .tokenKeyAccess(checkTokenAccess)
                .checkTokenAccess(checkTokenAccess);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient(clientId)
                .secret(passwordEncoder.encode(clientSecret))
                .authorizedGrantTypes(grantType.split(","))
                .scopes(scopes)
                .autoApprove(true)
                .accessTokenValiditySeconds(5000)
                .refreshTokenValiditySeconds(50000);
        //.redirectUris(RedirectURLs);
    }

}
