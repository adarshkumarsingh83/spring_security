package com.adarsh.spring.web.service;


import com.adarsh.spring.persistence.entity.User;

import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 1/1/13 00:11 AM#$
 */
public interface UserService {

    public User getUserByName(String userName);

    public List<User> getAllUser();

    public void saveUser(User user);
}
