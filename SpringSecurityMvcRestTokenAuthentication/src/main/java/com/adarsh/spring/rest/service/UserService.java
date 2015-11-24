package com.adarsh.spring.rest.service;

import com.adarsh.spring.rest.entity.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
public interface UserService {

    public List<User> getUserList();

    public User getUser(String username);

    public User getUser(String username,String password);

}
