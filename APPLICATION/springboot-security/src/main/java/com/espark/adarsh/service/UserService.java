package com.espark.adarsh.service;


import com.espark.adarsh.bean.UserBean;
import com.espark.adarsh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public UserBean getUserById(Long userId) {
        return this.userRepository.findById(userId)
                .get()
                .getUserBean();
    }

    public List<UserBean> getUsers() {
        return this.userRepository.findAll()
                .stream()
                .map(user -> user.getUserBean())
                .collect(Collectors.toList());
    }

    public UserBean createUser(UserBean userBean) {
        return this.userRepository.save(userBean.getUser()).getUserBean();
    }

    public UserBean updateUser(UserBean userBean) {
        return this.userRepository.save(userBean.getUser()).getUserBean();
    }

    public UserBean deleteUser(Long userId) {
        UserBean userBeanResponse =
                this.userRepository.findById(userId)
                        .get()
                        .getUserBean();
        this.userRepository.deleteById(userId);
        return userBeanResponse;
    }
}
