package com.espark.adarsh.spring.core.bean;

import com.espark.adarsh.spring.core.bean.view.AuthenticationView;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
@JsonPropertyOrder({"userName", "userPassword","token","message","httpStatus"})
public class ApiServerViewBean implements Serializable {

    @JsonView({AuthenticationView.class})
    @JsonProperty("User-Name")
    private String userName;

    @JsonView({AuthenticationView.class})
    @JsonProperty("User-Password")
    private String userPassword;

    @JsonView({AuthenticationView.class})
    @JsonProperty("Authentication-token")
    private String token;

    @JsonView({AuthenticationView.class})
    @JsonProperty("Response-Message")
    private String message;

    @JsonView({AuthenticationView.class})
    @JsonProperty("Response-Status")
    private Integer httpStatus;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(Integer httpStatus) {
        this.httpStatus = httpStatus;
    }
}
