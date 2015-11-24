package com.adarsh.spring.web.service;

import com.adarsh.spring.persistence.entity.UserRole;
import com.adarsh.spring.persistence.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 1/1/13 00:11 AM#$
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired(required = true)
    private RoleRepository roleRepository;

    @Transactional
    @Override
    public UserRole getRoleByName(String roleName) {
        return this.roleRepository.findByRoleName(roleName);
    }

    @Transactional
    @Override
    public List<UserRole> getAllRoles() {
        return this.roleRepository.findAll();
    }

    @Transactional
    @Override
    public void saveRole(UserRole role) {
        this.roleRepository.save(role);
    }
}
