package com.espark.adarsh.service;

import com.espark.adarsh.util.OAuthTokenMapperBean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;

@Service
public class TokenDataService {

    public OAuthTokenMapperBean getTokenData() {
        OAuthTokenMapperBean oAuthTokenMapperBean = (OAuthTokenMapperBean)
                ((OAuth2AuthenticationDetails) SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getDetails())
                        .getDecodedDetails();
        return oAuthTokenMapperBean;
    }
}
