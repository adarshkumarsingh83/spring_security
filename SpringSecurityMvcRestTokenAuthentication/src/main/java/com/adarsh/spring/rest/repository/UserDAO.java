
package com.adarsh.spring.rest.repository;


import com.adarsh.spring.rest.entity.User;

import java.text.ParseException;
import java.util.List;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
public interface UserDAO {

    public List<User> getUserList();

    public User getUser(String username);

    public User getUser(String username,String password);

}
