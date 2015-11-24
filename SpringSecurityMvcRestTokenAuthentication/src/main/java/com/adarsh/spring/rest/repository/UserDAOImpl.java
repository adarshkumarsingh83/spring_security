
package com.adarsh.spring.rest.repository;

import com.adarsh.spring.rest.entity.User;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
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
public class UserDAOImpl  implements UserDAO {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

	@Override
	public User getUser(String username) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", username));
		User user = (User) criteria.uniqueResult();
		return user;
	}

    @Override
    public User getUser(String username,String password) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.conjunction()
                .add(Restrictions.eq("userName", username))
                .add(Restrictions.eq("password", password)));
        User user = (User) criteria.uniqueResult();
        return user;
    }


    @Override
	public List<User> getUserList() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.setFetchMode("userGroupList", FetchMode.JOIN);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}
}
