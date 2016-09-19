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

import com.espark.adarsh.spring.persistence.entities.Department;
import com.espark.adarsh.spring.persistence.entities.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
@Scope(value = "singleton")
@Repository(value = "departmentRepositoryImpl")
public class DepartmentRepositoryImpl implements DepartmentRepository<Department> {

    @Autowired(required = true)
    protected SessionFactory sessionFactory;

    public DepartmentRepositoryImpl() {
    }

    @Override
    public Department getDeptByName(String deptName) {
        final Session session = getSession();
        final Criteria criteria = session.createCriteria(Department.class);
        criteria.add(Example.create(deptName));
        Department result = (Department) criteria.uniqueResult();
        return result;
    }

    @Override
    public List<Department> getAllDept() {
        final Session session = getSession();
        List<Department> rList = session.createCriteria(Department.class).list();
        return rList;
    }

    @Override
    public Department getDepartment(Integer employeeId){
        final Session session = getSession();
        final Criteria criteria = session.createCriteria(Department.class);
        criteria.add(Restrictions.eq("departmentId", employeeId));
        criteria.addOrder(Order.asc("departmentId"));
        Department entityObject = (Department) criteria.uniqueResult();
        return entityObject;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
