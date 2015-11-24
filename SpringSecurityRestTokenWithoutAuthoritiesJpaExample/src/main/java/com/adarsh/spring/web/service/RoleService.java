package com.adarsh.spring.web.service;

import com.adarsh.spring.persistence.entity.UserRole;

import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 1/1/13 00:11 AM#$
 */
public interface RoleService {

    public UserRole getRoleByName(String roleName);

    public List<UserRole> getAllRoles();

    public void saveRole(UserRole role);
}
