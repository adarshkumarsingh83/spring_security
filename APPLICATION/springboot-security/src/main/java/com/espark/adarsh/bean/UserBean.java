package com.espark.adarsh.bean;

import com.espark.adarsh.entity.User;
import com.espark.adarsh.entity.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class UserBean implements Serializable {

    private Long id;

    private String userName;

    private String userPwd;

    private String email;

    private Boolean isAdmin;

    private List<String> userRoles = new LinkedList<>();


    @JsonIgnore
    public User getUser() {
        User user = new User();
        user.setUserName(this.getUserName());
        user.setUserPwd(this.getUserPwd());
        user.setEmail(this.getEmail());

        this.userRoles.stream().map(roles -> {
            return new UserRole(roles);
        }).collect(Collectors.toList());

        user.setRoles(this.userRoles.stream().map(roles -> {
            return new UserRole(roles);
        }).collect(Collectors.toList()));
        return user;
    }
}
