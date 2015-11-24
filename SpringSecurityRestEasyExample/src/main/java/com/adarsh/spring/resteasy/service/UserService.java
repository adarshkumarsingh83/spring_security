package com.adarsh.spring.resteasy.service;




import com.adarsh.spring.resteasy.persistance.entity.User;

import java.util.List;

/**
 * Created by Adarsh on 3/14/15.
 */
public interface UserService {

    public User getUser(String login);

    public List<User> getUser();
}
