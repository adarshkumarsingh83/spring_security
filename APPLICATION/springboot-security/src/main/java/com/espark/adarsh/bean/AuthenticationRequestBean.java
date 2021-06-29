package com.espark.adarsh.bean;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class AuthenticationRequestBean {

    private String userName;
    private String userPwd;

}
