package com.adarsh.spring.repository;


import com.adarsh.spring.entity.impl.User;
import com.adarsh.spring.entity.impl.UserRole;

import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public interface RoleRepository <T> {

    public Long size();
    public void refreshUser(UserRole userRole);
    public UserRole getRoleByName(String roleName);
    public Boolean saveUserRole(UserRole userRole);
    public Boolean updateUserRole(UserRole userRole);
    public Boolean dropUserRole(UserRole userRole);
    public UserRole getUserRole(User user);
    public List<T> getAllUserRole(User user);
}
