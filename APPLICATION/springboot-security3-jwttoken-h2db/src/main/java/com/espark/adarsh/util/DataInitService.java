package com.espark.adarsh.util;

import com.espark.adarsh.bean.UserDetailInfo;
import com.espark.adarsh.entity.UserInfo;
import com.espark.adarsh.respository.UserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DataInitService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        log.info("DataInitService::init");
        UserInfo ADMIN = new UserInfo();
        ADMIN.setUserName("admin");
        ADMIN.setUserPassword(passwordEncoder.encode("admin"));
        ADMIN.setUserRole("ROLE_ADMIN,ROLE_USER");
        userInfoRepository.save(ADMIN);
        UserInfo USER = new UserInfo();
        USER.setUserName("user");
        USER.setUserPassword(passwordEncoder.encode("user"));
        USER.setUserRole("ROLE_USER");
        userInfoRepository.save(USER);
    }
}
