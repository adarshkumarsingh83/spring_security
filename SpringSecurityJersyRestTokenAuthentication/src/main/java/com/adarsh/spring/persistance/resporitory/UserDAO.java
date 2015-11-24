package com.adarsh.spring.persistance.resporitory;

import com.adarsh.spring.persistance.entity.User;

import java.util.List;

public interface UserDAO {
     
    public User getUser(String login);

    public List<User> getUser();
}