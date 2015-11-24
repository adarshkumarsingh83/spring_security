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
package com.espark.adarsh.spring.web.manager;


import com.espark.adarsh.spring.core.annotation.Manager;
import com.espark.adarsh.spring.persistence.entities.Department;
import com.espark.adarsh.spring.persistence.entities.Employee;
import com.espark.adarsh.spring.persistence.repository.DepartmentRepository;
import com.espark.adarsh.spring.persistence.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
@Scope("singleton")
@Manager("employeeManagerImpl")
public class EmployeeManagerImpl implements EmployeeManager {

    @Autowired(required = true)
    @Qualifier(value = "employeeRepositoryImpl")
    private EmployeeRepository employeeRepository;

    @Autowired(required = true)
    @Qualifier(value = "departmentRepositoryImpl")
    private DepartmentRepository departmentRepository;

    @Transactional
    @Override
    public List<Employee> getAllEmployee() {
        return (List<Employee>) this.employeeRepository.getAllEmployee();
    }

    @Transactional
    @Override
    public Employee getEmployee(Integer employeeId) {
        return (Employee) this.employeeRepository.getEmployee(employeeId);
    }

    @Transactional
    @Override
    public List<Department> getAllDepartment() {
        return this.departmentRepository.getAllDept();
    }

    @Transactional
    @Override
    public Department getDepartment(Integer departmentId) {
        return this.departmentRepository.getDepartment(departmentId);
    }
}
