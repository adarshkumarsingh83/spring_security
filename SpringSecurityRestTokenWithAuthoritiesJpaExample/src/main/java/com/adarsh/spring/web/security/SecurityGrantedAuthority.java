package com.adarsh.spring.web.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.Assert;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 1/1/13 00:11 AM#$
 */
public class SecurityGrantedAuthority implements GrantedAuthority {

    private final String role;

    public SecurityGrantedAuthority(String role) {
        Assert.hasText(role, "A granted authority textual representation is required");
        this.role = role;
    }

    public String getAuthority() {
        return role;
    }

    @JsonIgnore
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof SimpleGrantedAuthority) {
            return role.equals(((SecurityGrantedAuthority) obj).role);
        }

        return false;
    }

    @JsonIgnore
    public int hashCode() {
        return this.role.hashCode();
    }

    @JsonIgnore
    public String toString() {
        return this.role;
    }
}
