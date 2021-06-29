package com.espark.adarsh.bean;

import java.io.Serializable;

public class OAuthJwtPrincipal implements Serializable {

    private static final long serialVersionUID = 1L;
    private String username;
    private String email;

    public OAuthJwtPrincipal() {

    }

    public OAuthJwtPrincipal(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}