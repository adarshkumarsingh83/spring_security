package com.adarsh.spring.repository;


import com.adarsh.spring.entity.impl.User;

import java.util.Collection;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public interface UserRepository<T> {


    public Long size();

    public void refreshUser(User user);

    public Boolean saveUser(User user);

    public User getUser(User user);

    public User getUserById(User user);

    public User getUserByName(User user);

    public Boolean deleteUser(User user);

    public User updateUser(User user);

    public Collection<User> getAllUser();

}
