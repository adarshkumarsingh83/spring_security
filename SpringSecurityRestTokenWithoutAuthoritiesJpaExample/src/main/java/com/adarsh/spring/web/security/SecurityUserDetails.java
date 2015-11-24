package com.adarsh.spring.web.security;

import com.adarsh.spring.persistence.entity.User;
import com.adarsh.spring.persistence.entity.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 1/1/13 00:11 AM#$
 */
public class SecurityUserDetails implements UserDetails {

    private static final long TEN_DAYS = 1000 * 60 * 60 * 24 * 10;
    private String username;
    private String password;
    private boolean enabled = true;
    private boolean accountNonExpired = true;
    private boolean credentialsNonExpired = true;
    private boolean accountNonLocked = true;
    private long expires;
    private Set<SecurityGrantedAuthority> authorities = new HashSet<>();

    public SecurityUserDetails() {
    }

    public SecurityUserDetails(User user) {
        this.username = user.getUserName();
        this.password = user.getPassword();
        this.enabled = true;
        this.accountNonExpired = true;
        this.credentialsNonExpired = true;
        this.accountNonLocked = true;
        this.expires = System.currentTimeMillis() + TEN_DAYS;
        final Set<UserRole> userRoleSet = user.getRoles();
        if (userRoleSet != null) {
            this.setAuthorities(userRoleSet);
        }
    }

    public SecurityUserDetails(UserDetails user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.enabled = true;
        this.accountNonExpired = true;
        this.credentialsNonExpired = true;
        this.accountNonLocked = true;
        this.expires = System.currentTimeMillis() + TEN_DAYS;
        this.setAuthorities(user.getAuthorities());
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public long getExpires() {
        return expires;
    }

    public void setExpires(long expires) {
        this.expires = expires;
    }

    @Override
    public Set<SecurityGrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    public void setSecurityGrantedAuthority(Set<SecurityGrantedAuthority> authorities){
        this.authorities=authorities;
    }

    @JsonIgnore
    public void setAuthorities(Set<UserRole> userRoleSet) {
        if (!CollectionUtils.isEmpty(userRoleSet)) {
            for (UserRole userRole : userRoleSet) {
                authorities.add(new SecurityGrantedAuthority(userRole.getRoleName()));
            }
        }
    }

    @JsonIgnore
    public void setAuthorities( Collection<? extends GrantedAuthority> grantedAuthorities) {
        if (!CollectionUtils.isEmpty(grantedAuthorities)) {
            for (GrantedAuthority authority : grantedAuthorities) {
                authorities.add(new SecurityGrantedAuthority(authority.getAuthority()));
            }
        }
    }
}
