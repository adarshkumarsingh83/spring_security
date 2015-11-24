package com.adarsh.spring.web.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.util.Set;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 1/1/13 00:11 AM#$
 */
@Service
public class TokenAuthenticationService {

    private static final Logger log = LoggerFactory.getLogger(TokenAuthenticationService.class);
    @Value("${token.secret}")
    private static final String secret = "token";
    private static final String AUTH_HEADER_NAME = "X-AUTH-TOKEN";
    private static final long TEN_DAYS = 1000 * 60 * 60 * 24 * 10;

    private TokenHandler tokenHandler;


    public TokenAuthenticationService() {
        tokenHandler = new TokenHandler(DatatypeConverter.parseBase64Binary(secret));
    }

    public void addAuthentication(HttpServletResponse response, UserAuthentication authentication) {
        log.info("TokenAuthenticationService addAuthentication()");
        final SecurityUserDetails user = (SecurityUserDetails) authentication.getDetails();
        user.setExpires(System.currentTimeMillis() + TEN_DAYS);
        response.addHeader(AUTH_HEADER_NAME, tokenHandler.createTokenForUser(user));
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        log.info("TokenAuthenticationService getAuthentication()");
        final String token = request.getHeader(AUTH_HEADER_NAME);
        if (token != null) {
            log.info("TokenAuthenticationService getAuthentication() Token is Not Null in header");
            final UserDetails user = tokenHandler.parseUserFromToken(token);
            if (user != null) {
                log.info("TokenAuthenticationService getAuthentication() User is Obtained from Token " + user.getUsername());
                return new UserAuthentication(user);
            }
        }
        return null;
    }

    public void clearCacheForUser(HttpServletRequest request){

    }

    public final String getAuthenticationToken(final String userName) {
        log.info("TokenAuthenticationService getAuthenticationToken()");
        return this.tokenHandler.getAuthenticationToken(userName);
    }

    public String removeAuthenticationToken(final String userName) {
        log.info("TokenAuthenticationService removeAuthenticationToken()");
        return this.tokenHandler.removeAuthenticationToken(userName);
    }

    public final Set<SecurityGrantedAuthority> getAuthoritiesFromCache(final String userName) {
        log.info("TokenAuthenticationService getAuthoritiesFromCache()");
        return this.tokenHandler.getAuthoritiesFromCache(userName);
    }

    public final Set<SecurityGrantedAuthority> removeAuthoritiesFromCache(final String userName) {
        log.info("TokenAuthenticationService removeAuthoritiesFromCache()");
        return this.tokenHandler.removeAuthoritiesFromCache(userName);
    }
}
