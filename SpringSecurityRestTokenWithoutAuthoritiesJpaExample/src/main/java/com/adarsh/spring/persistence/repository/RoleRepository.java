package com.adarsh.spring.persistence.repository;

import com.adarsh.spring.persistence.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 1/1/13 00:11 AM#$
 */
public interface RoleRepository extends JpaRepository<UserRole,Long> {

    public UserRole findByRoleName(String roleName);
}
