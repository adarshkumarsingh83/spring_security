package com.espark.adarsh.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

public class ApplicationUtil {

    public static String getAccessToken() {
        Object detailsObject = (SecurityContextHolder.getContext().getAuthentication() != null)
                ? (SecurityContextHolder.getContext().getAuthentication().getDetails() != null)
                ? SecurityContextHolder.getContext().getAuthentication().getDetails() : null
                : null;

        if (detailsObject != null) {
            OAuth2AuthenticationDetails authenticationDetails = (OAuth2AuthenticationDetails) detailsObject;
            return authenticationDetails.getTokenType().concat(" ").concat(authenticationDetails.getTokenValue());
        }
        return "";
    }

}
