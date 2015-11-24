package com.adarsh.spring.repository.impl;


import com.adarsh.spring.entity.impl.User;
import com.adarsh.spring.entity.impl.UserRole;
import com.adarsh.spring.repository.RoleRepository;
import com.adarsh.spring.repository.construct.AbstractRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Repository
public class RoleRepositoryImpl extends AbstractRepository<UserRole>
        implements RoleRepository<UserRole> {

    public RoleRepositoryImpl() {
        super(UserRole.class);
    }

    @Override
    @Transactional
    public Long size() {
        return super.size();
    }

    @Override
    public void refreshUser(UserRole userRole) {
        super.refresh(userRole);
    }

    @Override
    @Transactional
    public Boolean saveUserRole(UserRole userRole) {
        super.put(userRole);
        return null;
    }

    @Override
    @Transactional
    public UserRole getRoleByName(String roleName) {
         UserRole userRole=new UserRole();
          userRole.setName(roleName);
        return (UserRole) super.getUniqueByExample(userRole);
    }

    @Override
    @Transactional
    public Boolean updateUserRole(UserRole userRole) {
        super.update(userRole);
        return null;
    }

    @Override
    @Transactional
    public Boolean dropUserRole(UserRole userRole) {
        super.remove(userRole);
        return null;
    }

    @Override
    @Transactional
    public UserRole getUserRole(User user) {
        UserRole UserUserRole = new UserRole();
        UserUserRole.setId(1L);
        UserUserRole.setName("User");
        return null;
    }

    @Override
    public List<UserRole> getAllUserRole(User user) {
        return super.getAll();
    }
}
