package com.adarsh.spring.resteasy.service;



import com.adarsh.spring.resteasy.persistance.entity.Role;
import com.adarsh.spring.resteasy.persistance.resporitory.RoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Adarsh on 3/14/15.
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    public Role getRole(int id) {
        return roleDAO.getRole(id);
    }

}