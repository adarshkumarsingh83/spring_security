package com.adarsh.spring.rest.service;

import com.adarsh.spring.rest.resporitory.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.adarsh.spring.rest.entity.User;

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
