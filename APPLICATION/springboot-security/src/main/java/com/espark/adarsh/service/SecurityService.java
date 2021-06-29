package com.espark.adarsh.service;

import com.espark.adarsh.bean.UserBean;
import com.espark.adarsh.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.espark.adarsh.entity.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SecurityService {

    @Autowired
    private UserRepository userRepository;

    public User findUserByName(String userName) {
        com.espark.adarsh.entity.User user = this.userRepository.findByUserName(userName);
        if (user != null) {
            return user;
        }
        throw new UsernameNotFoundException("User Not Found for name" + userName);
    }

    public UserBean getUserDetails(String userName) {
        com.espark.adarsh.entity.User user = this.userRepository.findByUserName(userName);
        if (user != null) {
            List<String> roles = user.getRoles()
                    .stream()
                    .map(userRole -> userRole.getRoleName())
                    .collect(Collectors.toList());
            UserBean userBean = new UserBean();
            userBean.setId(user.getId());
            userBean.setUserName(user.getUserName());
            userBean.setUserRoles(roles);
            return userBean;
        }
        throw new UsernameNotFoundException("User Not Found for name" + userName);
    }
}
