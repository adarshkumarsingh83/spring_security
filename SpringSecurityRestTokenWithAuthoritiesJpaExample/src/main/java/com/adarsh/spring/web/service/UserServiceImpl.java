package com.adarsh.spring.web.service;

import com.adarsh.spring.persistence.entity.User;
import com.adarsh.spring.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 1/1/13 00:11 AM#$
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = true)
    private UserRepository userRepository;

    @Transactional
    @Override
    public User getUserByName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Transactional
    @Override
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    @Transactional(readOnly = false)
    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }
}
