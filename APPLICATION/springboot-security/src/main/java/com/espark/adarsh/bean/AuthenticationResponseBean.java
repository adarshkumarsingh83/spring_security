package com.espark.adarsh.bean;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class AuthenticationResponseBean {

    private String token;
    private String message;
    private UserBean userBean;

}
