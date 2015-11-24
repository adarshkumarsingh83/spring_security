
package com.adarsh.spring.rest.repository;

import com.adarsh.spring.rest.entity.Permission;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
@Repository
public class PermissionDAOImpl  implements
		PermissionDAO {

    @Autowired(required = true)
    private SessionFactory sessionFactory;
   

	@Override
	public List<Permission> getAllPermissions() {
		
		// Start a hiberate session and return the all the permissions from the database
                    
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Permission.class);
	    return criteria.list();
	}

	@Override
	public List<Permission> getPermission(List<Long> permissionId) {
		Session session = this.sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Permission.class);
		criteria.add(Restrictions.in("permissionId", permissionId.toArray()));
		return criteria.list();
	}

	@Override
	public List<Permission> getUserPermissionsByPermissionGroupName(String permissionGroupName) {

		Session session = this.sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Permission.class);

		criteria.createAlias("permissionGroupSet", "pg");
		criteria.add(Restrictions.eq("pg.permissionGroupName",
                permissionGroupName));
		return criteria.list();
	}

	@Override
	public Permission getPermissionByName(String permissionName) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Permission.class);

		criteria.add(Restrictions.eq("permissionName", permissionName));

		Permission permission = (Permission) criteria.uniqueResult();

		return permission;
	}

}
