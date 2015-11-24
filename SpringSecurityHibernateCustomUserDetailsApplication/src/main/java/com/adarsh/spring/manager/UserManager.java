package com.adarsh.spring.manager;


import com.adarsh.spring.entity.impl.User;
import com.adarsh.spring.entity.impl.UserRole;

import java.util.Collection;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public interface UserManager <M> {
    public void refreshUser(User user);
    public Boolean saveUser(User user);
    public Boolean updateUser(User user);
    public Boolean deleteUser(User user);
    public User getUser(User user);
    public User getUserById(User user);
    public User getUserByName(User user);
    public Collection<User> getAllUser();
    public UserRole getUserRole(String roleName);
}
