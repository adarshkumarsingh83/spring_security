/*
 * Copyright (c) 2015 Espark And ©Adarsh Development Services @copyright All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Espark nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.espark.adarsh.spring.persistence.repository;

import com.espark.adarsh.spring.persistence.entities.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
@Scope(value = "singleton")
@Repository(value = "userRepositoryImpl")
public class UserRepositoryImpl  implements UserRepository<User> {


    @Autowired(required = true)
    protected SessionFactory sessionFactory;

    public UserRepositoryImpl() {
    }

    @Override
    @Transactional
    public Boolean saveUser(User user) {
        final Session session = getSession();
        session.saveOrUpdate(user);
        return null;
    }

    @Override
    @Transactional
    public User getUser(User user) {
        final Session session = getSession();
        final Criteria criteria = session.createCriteria(User.class);
        criteria.add(Example.create(user));
        User result = (User) criteria.uniqueResult();
        return result;
    }

    @Override
    @Transactional
    public User getUserById(User user) {
        final Session session = getSession();
        final Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("id", user.getId()));
        User entityObject = (User) criteria.uniqueResult();
        return entityObject;
    }

    @Override
    @Transactional
    public Collection<User> getAllUser() {
        final Session session = getSession();
        List<User> rList = session.createCriteria(User.class).list();
        return rList;
    }

    @Override
    public User getUserByName(User user) {
        final Session session = getSession();
        final Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("userName", user.getUserName()));
        final User entity = (User) criteria.uniqueResult();
        return entity;
    }


    @Override
    public List<User> getByExample(final User example) {
        final Session session = getSession();
        final Criteria criteria = session.createCriteria(User.class);
        criteria.add(Example.create(example));
        final List<User> list = criteria.list();
        return list;
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

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}