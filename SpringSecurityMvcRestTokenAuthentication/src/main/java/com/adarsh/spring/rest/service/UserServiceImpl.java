package com.adarsh.spring.rest.service;

import com.adarsh.spring.rest.entity.Permission;
import com.adarsh.spring.rest.entity.PermissionGroup;
import com.adarsh.spring.rest.entity.User;
import com.adarsh.spring.rest.repository.PermissionDAO;
import com.adarsh.spring.rest.repository.PermissionGroupDAO;
import com.adarsh.spring.rest.repository.UserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import java.util.*;


/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
@Service("userService")
@Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
public class UserServiceImpl implements UserService {

    private static Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserDAO userDAO;
    private final PermissionGroupDAO permissionGroupDAO;
    private final PermissionDAO permissionDAO;
    private final MessageSource messageSource;


    @Autowired
    public UserServiceImpl(UserDAO userDAO,
                           PermissionGroupDAO permissionGroupDAO
            , PermissionDAO permissionDAO,
                           MessageSource messageSource) {
        this.userDAO = userDAO;
        this.permissionGroupDAO = permissionGroupDAO;
        this.permissionDAO = permissionDAO;
        this.messageSource = messageSource;

    }


    @Override
    @Transactional(readOnly = true)
    public User getUser(String username) {
        final User user = userDAO.getUser(username);
        if (user != null) {
            final List<PermissionGroup> userPermissionGroupList = user.getUserPermissionGroupList();
            if (!CollectionUtils.isEmpty(userPermissionGroupList)) {
                for (PermissionGroup permissionGroup : userPermissionGroupList) {
                    final Set<Permission> p = permissionGroup.getPermissionsSet();
                    user.setPermissionsSet(p);
                }
            }
        }
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(String username,String password) {
        final User user = userDAO.getUser(username,password);
        if (user != null) {
            final List<PermissionGroup> userPermissionGroupList = user.getUserPermissionGroupList();
            if (!CollectionUtils.isEmpty(userPermissionGroupList)) {
                for (PermissionGroup permissionGroup : userPermissionGroupList) {
                    final Set<Permission> p = permissionGroup.getPermissionsSet();
                    user.setPermissionsSet(p);
                }
            }
        }
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getUserList() {
        return userDAO.getUserList();
    }
}
