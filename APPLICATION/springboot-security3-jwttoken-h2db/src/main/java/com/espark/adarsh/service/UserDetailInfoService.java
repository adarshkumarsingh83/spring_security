package com.espark.adarsh.service;

import com.espark.adarsh.bean.UserDetailInfo;
import com.espark.adarsh.entity.UserInfo;
import com.espark.adarsh.respository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailInfoService implements UserDetailsService {

    @Autowired
    private UserInfoRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = repository.findByUserName(username);
        return userInfo.map(UserDetailInfo::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }

}