package com.adarsh.spring.rest.resporitory;

import com.adarsh.spring.rest.entity.User;

import java.util.List;

public interface UserDAO {
     
    public User getUser(String login);

    public List<User> getUser();
}