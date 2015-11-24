package com.adarsh.spring.manager;


import com.adarsh.spring.entity.impl.User;
import com.adarsh.spring.entity.impl.UserRole;
import com.adarsh.spring.repository.RoleRepository;
import com.adarsh.spring.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Service
final public class UserManagerImpl
        implements UserManager {

    private final static Logger logger = LoggerFactory.getLogger(UserManagerImpl.class);

    public UserManagerImpl() {
    }

    @Override
    public void refreshUser(User user) {
        userRepository.refreshUser(user);
    }

    @Transactional
    public Boolean saveUser(User user) {
        userRepository.saveUser(user);
        return null;
    }

    @Transactional
    public Boolean updateUser(User user) {
        userRepository.updateUser(user);
        return null;
    }

    @Transactional
    public Boolean deleteUser(User user) {
        userRepository.deleteUser(user);
        return null;
    }

    public User getUser(final User user) {
        return  userRepository.getUser(user);
    }

    @Override
    public Collection<User> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public User getUserById(User user) {
        return userRepository.getUserById(user);
    }

    @Override
    public User getUserByName(User user) {
        return userRepository.getUserByName(user);
    }

    @Override
    public UserRole getUserRole(String roleName) {
        return roleRepository.getRoleByName(roleName);
    }

    @Qualifier("userRepositoryImpl")
    @Autowired
    private UserRepository userRepository;

    public void setUserRepository(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Qualifier("roleRepositoryImpl")
    @Autowired
    private RoleRepository roleRepository;

    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
