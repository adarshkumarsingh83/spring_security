package com.adarsh.spring.repository.impl;



import com.adarsh.spring.entity.impl.User;
import com.adarsh.spring.repository.UserRepository;
import com.adarsh.spring.repository.construct.AbstractRepository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Repository
public class UserRepositoryImpl extends AbstractRepository<User>
        implements UserRepository<User> {

    public UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    @Transactional
    public Boolean saveUser(User user) {
        super.put(user);
        return null;
    }

    @Override
    @Transactional
    public User getUser(User user) {
        return getUniqueByExample(user);
    }

    @Override
    @Transactional
    public User getUserById(User user) {
        return (User) super.getEntityById(user);
    }

    @Override
    @Transactional
    public User getUserByName(User user) {
        return (User) super.getByColumnName("userName",user.getUserName());
    }

    @Override
    @Transactional
    public Boolean deleteUser(User user) {
        super.remove(user);
        return null;
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        super.update(user);
        return null;
    }


    @Override
    @Transactional
    public Collection<User> getAllUser() {
        return getAll();
    }


    @Transactional
    public User getFacebookUser(String facebookUserEmailId){
        Criteria criteria=getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("userEmail",facebookUserEmailId)) ;
        Object object=criteria.uniqueResult();
        if(object!=null){
            return (User)object;
        }
        return (User)object;
    }

    @Override
    @Transactional
    public Long size() {
        return super.size();
    }

    @Override
    public void refreshUser(User user) {
        super.refresh(user);
    }
}