package com.adarsh.spring.resteasy.service;



import com.adarsh.spring.resteasy.persistance.entity.User;
import com.adarsh.spring.resteasy.persistance.resporitory.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Adarsh on 3/14/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public User getUser(String login) {
        return userDAO.getUser(login);
    }

    @Transactional
    public List<User> getUser(){
        return userDAO.getUser();

    }

}
