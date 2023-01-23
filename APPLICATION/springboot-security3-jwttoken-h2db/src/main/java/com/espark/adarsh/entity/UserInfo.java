package com.espark.adarsh.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "userinfo")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;
     private String userName;
     private String userPassword;
     private String userRole;

    public UserInfo() {
    }

}

