package com.espark.adarsh.service;

import com.espark.adarsh.entity.User;
import com.espark.adarsh.entity.UserRole;
import com.espark.adarsh.repository.UserRepository;
import com.espark.adarsh.repository.UserRoleRepository;
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
        adarsh.setPassword("adarsh");
        adarsh = this.userRepository.save(adarsh);

        User radha = new User();
        radha.setUserName("radha");
        radha.setPassword("radha");
        radha = this.userRepository.save(radha);

        User user = new User();
        user.setUserName("user");
        user.setPassword("user");
        user = this.userRepository.save(user);

        User guest = new User();
        guest.setUserName("guest");
        guest.setPassword("guest");
        guest = this.userRepository.save(guest);

        adarsh.setUserRole(adminRole);
        this.userRepository.save(adarsh);
        radha.setUserRole(adminRole);
        this.userRepository.save(radha);
        user.setUserRole(userRole);
        this.userRepository.save(user);
        guest.setUserRole(guestRole);
        this.userRepository.save(guest);

        adminRole.setUser(adarsh);
        adminRole.setUser(radha);
        this.userRoleRepository.save(adminRole);

        userRole.setUser(user);
        this.userRoleRepository.save(userRole);

        guestRole.setUser(guest);
        this.userRoleRepository.save(guestRole);

    }
}