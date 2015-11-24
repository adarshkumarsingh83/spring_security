package com.adarsh.spring.web.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 1/1/13 00:11 AM#$
 */
public final class TokenHandler {

    private static final Logger log = LoggerFactory.getLogger(TokenHandler.class);
    private static final HashMap<String, String> tokenCache = new HashMap<>();
    private static final String HMAC_ALGO = "HmacSHA256";
    private static final String SEPARATOR_SPLITTER = "\\.";
    private static final String SEPARATOR = ".";
    private Mac hmac;

    public TokenHandler(byte[] secretKey) {
        try {
            hmac = Mac.getInstance(HMAC_ALGO);
            hmac.init(new SecretKeySpec(secretKey, HMAC_ALGO));
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            log.error(e.getLocalizedMessage());
            throw new IllegalStateException("failed to initialize HMAC: " + e.getMessage(), e);
        }
    }

    public String createTokenForUser(SecurityUserDetails user) {
        log.info("TokenHandler createTokenForUser()");
        final byte[] userBytes = this.securityUserDetailsToJson(user);
        final byte[] userHash = this.createHmac(userBytes);
        final byte[] authBytes = this.securityGrantedAuthoritySetToJson(user.getSecurityGrantedAuthorityList());
        final byte[] authHash = this.createHmac(authBytes);
        final StringBuilder sb = new StringBuilder(500);
        sb.append(toBase64(userBytes));
        sb.append(SEPARATOR);
        sb.append(toBase64(userHash));
        sb.append(SEPARATOR);
        sb.append(toBase64(authBytes));
        sb.append(SEPARATOR);
        sb.append(toBase64(authHash));
        sb.trimToSize();
        log.info("TokenHandler createTokenForUser() is Added To Token Cache");
        tokenCache.put(user.getUsername(), sb.toString());
        return sb.toString();
    }

    public SecurityUserDetails parseUserFromToken(String token) {
        log.info("TokenHandler parseUserFromToken()");
        final String[] parts = token.split(SEPARATOR_SPLITTER);
        if (parts.length == 4 && parts[0].length() > 0 && parts[1].length() > 0
                && parts[2].length() > 0 && parts[3].length() > 0) {
            try {
                final byte[] userBytes = fromBase64(parts[0]);
                final byte[] hash = fromBase64(parts[1]);
                final byte[] authBytes = fromBase64(parts[2]);
                final byte[] authHash = fromBase64(parts[3]);
                boolean validHash = Arrays.equals(createHmac(userBytes), hash);
                if (validHash) {
                    final SecurityUserDetails user = this.securityUserDetailsFromJson(userBytes);
                    log.info("TokenHandler parseUserFromToken() Valid User Hash in Token ");
                    validHash = Arrays.equals(createHmac(authBytes), authHash);
                    if (validHash) {
                        log.info("TokenHandler parseUserFromToken() Valid Authority Hash in Token ");
                       final Set<SecurityGrantedAuthority> securityGrantedAuthorities = this.securityGrantedAuthoritySetFromJson(authBytes);
                       user.setSecurityGrantedAuthority(securityGrantedAuthorities);
                    }
                    if (new Date().getTime() < user.getExpires() && tokenCache.containsKey(user.getUsername())) {
                        log.info("TokenHandler parseUserFromToken() Token is Still Valid by Expiration Time ");
                        return user;
                    } else {
                        log.info("TokenHandler parseUserFromToken() Token is not Valid by Expiration Time Removed From Cache");
                        tokenCache.remove(user.getUsername());
                    }
                }
            } catch (IllegalArgumentException e) {
                log.error(e.getLocalizedMessage());
                throw e;
            }
        }
        return null;
    }

    private SecurityUserDetails securityUserDetailsFromJson(final byte[] userBytes) {
        try {
            return new ObjectMapper().readValue(new ByteArrayInputStream(userBytes), SecurityUserDetails.class);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private Set<SecurityGrantedAuthority> securityGrantedAuthoritySetFromJson(final byte[] userBytes) {
        try {
            final List<String> authList = new ObjectMapper().readValue(new ByteArrayInputStream(userBytes), ArrayList.class);
            final Set<SecurityGrantedAuthority> authorities = new HashSet<>();
            for (String authName : authList) {
                authorities.add(new SecurityGrantedAuthority(authName));
            }
            return authorities;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private byte[] securityUserDetailsToJson(SecurityUserDetails user) {
        try {
            return new ObjectMapper().writeValueAsBytes(user);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(e);
        }
    }

    private byte[] securityGrantedAuthoritySetToJson(List grantedAuthorities) {
        try {
            return new ObjectMapper().writeValueAsBytes(grantedAuthorities);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(e);
        }
    }

    private String toBase64(byte[] content) {
        return DatatypeConverter.printBase64Binary(content);
    }

    private byte[] fromBase64(String content) {
        return DatatypeConverter.parseBase64Binary(content);
    }

    // synchronized to guard internal hmac object
    private synchronized byte[] createHmac(byte[] content) {
        return hmac.doFinal(content);
    }

    public final String getAuthenticationToken(final String userName ){
        if(!tokenCache.containsKey(userName)){
            throw new RuntimeException("User Token Not Found");
        }else{
         return tokenCache.get(userName);
        }
    }
}
