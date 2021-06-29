/*
 * Copyright (c) 2015 Espark And ©Adarsh Development Services @copyright All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Espark nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
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
 * @Espark @copyright all right reserve
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
