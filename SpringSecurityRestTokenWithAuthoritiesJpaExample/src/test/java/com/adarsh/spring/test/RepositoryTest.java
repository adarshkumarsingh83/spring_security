package com.adarsh.spring.test;

import com.adarsh.spring.persistence.entity.User;
import com.adarsh.spring.persistence.entity.UserRole;
import com.adarsh.spring.web.service.RoleService;
import com.adarsh.spring.web.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 1/1/13 00:11 AM#$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/configuration/applicationContext.xml"})
public class RepositoryTest {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Transactional
    @Test
    public void testFindByUsername() {
        User user = userService.getUserByName("adarsh");
        System.out.println(user);
    }

    @Rollback(false)
    @Transactional(readOnly = false)
    @Test
    public void saveUser(){
        final UserRole role=new UserRole();
        role.setRoleName("USER_ROLE4");
        this.roleService.saveRole(role);
        final User user=new User();
        user.setFirstName("User4");
        user.setLastName("User4");
        user.setUserName("User4");
        user.setPassword("Pwd");
        user.setEmail("adarsh@kumar.com");
        user.setPhoneNumber("9999999");
        user.setRoles(role);
        this.userService.saveUser(user);
        User user1 = userService.getUserByName("User4");
        System.out.println(user1);
    }

    @Transactional
    @Test
    public void testFindAll() {
        final List<User> userList = this.userService.getAllUser();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
