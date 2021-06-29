package com.espark.adarsh.service;

import com.espark.adarsh.entity.User;
import com.espark.adarsh.entity.UserRole;
import com.espark.adarsh.repository.UserRepository;
import com.espark.adarsh.repository.UserRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import javax.transaction.Transactional;

@Slf4j
@Service
public class DataInitService {


    @Autowired
    DataSource dataSource;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    UserRepository userRepository;

    @Transactional
    @PostConstruct
    public void init() {
        Resource initSchema = new ClassPathResource("data.sql");
        DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema);
        DatabasePopulatorUtils.execute(databasePopulator, dataSource);

        UserRole adminRole = new UserRole();
        adminRole.setRoleName("ADMIN");
        adminRole = this.userRoleRepository.save(adminRole);

        UserRole userRole = new UserRole();
        userRole.setRoleName("USER");
        userRole = this.userRoleRepository.save(userRole);

        UserRole guestRole = new UserRole();
        guestRole.setRoleName("GUEST");
        guestRole = this.userRoleRepository.save(guestRole);

        User adarsh = new User();
        adarsh.setUserName("adarsh");
        adarsh.setUserPwd("adarsh");
        adarsh.setEmail("adarsh@kumar");
        adarsh = this.userRepository.save(adarsh);

        User radha = new User();
        radha.setUserName("radha");
        radha.setUserPwd("radha");
        radha.setEmail("radha@singh");
        radha = this.userRepository.save(radha);

        User user = new User();
        user.setUserName("user");
        user.setUserPwd("user");
        user.setEmail("user@espark");
        user = this.userRepository.save(user);

        User admin = new User();
        admin.setUserName("admin");
        admin.setUserPwd("admin");
        admin.setEmail("admin@espark");
        admin = this.userRepository.save(admin);

        User guest = new User();
        guest.setUserName("guest");
        guest.setUserPwd("guest");
        guest.setEmail("guest@espark");
        guest = this.userRepository.save(guest);

        adarsh.setUserRole(adminRole);
        this.userRepository.save(adarsh);
        radha.setUserRole(adminRole);
        this.userRepository.save(radha);
        admin.setUserRole(adminRole);
        this.userRepository.save(admin);
        user.setUserRole(userRole);
        this.userRepository.save(user);
        guest.setUserRole(guestRole);
        this.userRepository.save(guest);

        adminRole.setUser(adarsh);
        adminRole.setUser(radha);
        adminRole.setUser(admin);
        this.userRoleRepository.save(adminRole);

        userRole.setUser(user);
        this.userRoleRepository.save(userRole);

        guestRole.setUser(guest);
        this.userRoleRepository.save(guestRole);

    }
}