package com.adarsh.spring.services;


import com.adarsh.spring.persistance.entity.User;

import java.util.List;

/**
 * Created by Adarsh on 3/14/15.
 */
public interface UserService {

    public User getUser(String login);

    public List<User> getUser();
}
