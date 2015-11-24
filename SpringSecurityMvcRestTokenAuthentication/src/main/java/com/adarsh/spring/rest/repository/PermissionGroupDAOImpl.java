
package com.adarsh.spring.rest.repository;

import com.adarsh.spring.rest.entity.PermissionGroup;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.List;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
@Repository
public class PermissionGroupDAOImpl  implements PermissionGroupDAO {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

	@Override
	public List<PermissionGroup> getAllPermissionGroups(List<Long> permissionGroupId) {
		
		Session session =this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PermissionGroup.class);
		criteria.add(Restrictions.in("permissionGroupId", permissionGroupId.toArray()));
		
		return criteria.list();
	}

	@Override
	public PermissionGroup getPermissionGroupByName(String permissionGroupName) {
		
		Session session =this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PermissionGroup.class);
		criteria.add(Restrictions.eq("permissionGroupName", permissionGroupName));
		PermissionGroup permissionGroup = (PermissionGroup) criteria.uniqueResult();
		
		return permissionGroup;
	}

	@Override
	public List<PermissionGroup> getUserPermissionGroupsByUsername(
			String username) {
		Session session =this.sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(PermissionGroup.class);
		
		criteria.createAlias("userSet", "u");
		criteria.add(Restrictions.eq("u.userName", username));
		
		return criteria.list();
	}


    @Override
    public List<String> getPermissionGroupNames() throws ParseException {

        Session session =this.sessionFactory.getCurrentSession();

        Criteria criteria = session.createCriteria(PermissionGroup.class);
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("permissionGroupName")));

        return criteria.list();
    }

}
