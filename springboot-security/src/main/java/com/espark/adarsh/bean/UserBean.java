package com.espark.adarsh.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Data
public class UserBean implements Serializable {

    private Long id;

    private String userName;

    private String password;

    private List<String> userRoles = new LinkedList<>();
}