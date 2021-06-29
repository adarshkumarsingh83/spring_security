package com.espark.adarsh.spring.web.security;



import com.espark.adarsh.spring.persistence.entities.User;
import com.espark.adarsh.spring.web.manager.UserManager;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
@Component
public class TokenProvider {

    @Qualifier(value = "userManagerImpl")
    @Autowired(required = true)
    private UserManager userManager;

    @Value("${token-secret-key}")
    private String secretKey;


    private MessageDigest md5er;


    static String FENCE_POST = "!!!";
    private static final String NEWLINE = "\r\n";


    public TokenProvider() {
        try {
            md5er = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Cannot find MD5 algorithm",e);
        }
    }

    public String getToken(User user) {
        return getToken(user, DateTime.now().plusDays(1).getMillis());
    }

    public String getToken(User user, long expirationDateInMillis) {

        StringBuilder tokenBuilder = new StringBuilder();

        byte[] token = tokenBuilder
                .append(user.getUserName())
                .append(FENCE_POST)
                .append(expirationDateInMillis)
                .append(FENCE_POST)
                .append(new String(buildTokenKey(expirationDateInMillis, user)))
                .toString().getBytes();

        // the below function returns a string ending in "\r\n", which tends to cause problems...remove it
        return Base64.encodeBase64String(token).replace(NEWLINE, "");
    }

    public boolean isTokenValid(String encodedToken) {
        String[] components = decodeAndDissectToken(encodedToken);

        if (components == null || components.length != 3) {
            return false;
        }
        String externalUser = components[0];
        Long externalDate = Long.parseLong(components[1]);
        String externalKey  = components[2];
        User user = userManager.getUniqueUserByExample(new User(externalUser));
        String expectedKey = new String(buildTokenKey(externalDate, user));
        byte[] expectedKeyBytes = expectedKey.getBytes();
        byte[] externalKeyBytes = externalKey.getBytes();
        if (!MessageDigest.isEqual(expectedKeyBytes, externalKeyBytes)) {
            return false;
        }

        if (new DateTime(externalDate).isBeforeNow()) {
            return false;
        }

        return true;
    }

    private byte[] buildTokenKey(long expirationDateInMillis, User user) {
        Assert.notNull(secretKey, "Secret Key must not be null!");
        StringBuilder keyBuilder = new StringBuilder();
        String key = keyBuilder
                .append(user.getUserName())
                .append(FENCE_POST)
                .append(user.getPassword())
                .append(FENCE_POST)
                .append(expirationDateInMillis)
                .append(FENCE_POST)
                .append(secretKey).toString();

        byte[] keyBytes = key.getBytes();
        return md5er.digest(keyBytes);
    }

    public User getUserFromToken(String token) {
        if (!isTokenValid(token)) { return null; }
        String[] components = decodeAndDissectToken(token);
        if (components == null || components.length != 3) { return null; }
        String username = components[0];
        return userManager.getUniqueUserByExample(new User(username));
    }

    private String[] decodeAndDissectToken(String encodedToken) {
        if(StringUtils.isBlank(encodedToken) || !Base64.isArrayByteBase64(encodedToken.getBytes())) {
            return null;
        }
        // Apache Commons Base64 tools expect Base64 strings to end in "\r\n", add if necessary
        if(!encodedToken.endsWith(NEWLINE)) { encodedToken = encodedToken + NEWLINE; }
        String token = new String(Base64.decodeBase64(encodedToken));
        if(!token.contains(FENCE_POST) || token.split(FENCE_POST).length != 3) {
            return null;
        }
        return token.split(FENCE_POST);
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public MessageDigest getMd5er() {
        return md5er;
    }

    public void setMd5er(MessageDigest md5er) {
        this.md5er = md5er;
    }


}

