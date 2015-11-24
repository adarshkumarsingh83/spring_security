package com.adarsh.spring.resteasy.persistance.resporitory;


import com.adarsh.spring.resteasy.persistance.entity.User;

import java.util.List;

public interface UserDAO {
     
    public User getUser(String login);

    public List<User> getUser();
}