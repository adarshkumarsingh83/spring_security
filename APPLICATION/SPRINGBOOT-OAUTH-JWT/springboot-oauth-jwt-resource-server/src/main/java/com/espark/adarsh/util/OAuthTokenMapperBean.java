package com.espark.adarsh.util;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;
import java.util.stream.Collectors;

public class OAuthTokenMapperBean implements Serializable {

    private String access_token;
    private String id;
    private String userName;
    private String name;
    private Collection<GrantedAuthority> authorities;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public String getAuthoritiesData() {
        String data = "";
        if (authorities != null) {
            data = authorities.stream().map(authorities -> authorities.getAuthority())
                    .collect(Collectors.toList()).toString();
        }
        return data;
    }

    @Override
    public String toString() {
        return "{" +
                "access_token='" + access_token + '\'' +
                ", id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", authorities=" + getAuthoritiesData() +
                '}';
    }
}
