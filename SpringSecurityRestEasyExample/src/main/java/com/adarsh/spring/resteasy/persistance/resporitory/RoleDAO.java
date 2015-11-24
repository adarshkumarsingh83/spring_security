package com.adarsh.spring.resteasy.persistance.resporitory;


import com.adarsh.spring.resteasy.persistance.entity.Role;

/**
 * Created by Adarsh on 3/14/15.
 */
public interface RoleDAO {

    public Role getRole(int id);

}