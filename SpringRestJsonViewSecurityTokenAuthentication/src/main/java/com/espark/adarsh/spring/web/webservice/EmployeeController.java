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
package com.espark.adarsh.spring.web.webservice;


import com.espark.adarsh.spring.core.annotation.ResponseView;
import com.espark.adarsh.spring.core.annotation.RestWebService;
import com.espark.adarsh.spring.core.bean.DepartmentViewBean;
import com.espark.adarsh.spring.core.bean.EmployeeViewBean;
import com.espark.adarsh.spring.core.bean.view.EmployeeDetailView;
import com.espark.adarsh.spring.core.bean.view.EmployeeView;
import com.espark.adarsh.spring.persistence.entities.Employee;
import com.espark.adarsh.spring.web.manager.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
@RestWebService
public class EmployeeController {

    @Autowired(required = true)
    private EmployeeManager employeeManager;

    // http://localhost:8080/SpringRestJsonViewSecurityTokenAuthentication/employee
    @RequestMapping("/employee")
    public
    @ResponseBody
    List<EmployeeViewBean> getEmployees() {
        final List<Employee> employeesList=this.employeeManager.getAllEmployee();
        final List<EmployeeViewBean> employeeViewBeans=new ArrayList<>(employeesList.size());
        for(Employee employee:employeesList){
            employeeViewBeans.add(new EmployeeViewBean(employee));
        }
        return employeeViewBeans;
    }


    // http://localhost:8080/SpringRestJsonViewSecurityTokenAuthentication/employee/all
    @RequestMapping("/employee/all")
    @ResponseView(EmployeeView.class)
    public
    @ResponseBody
    List<EmployeeViewBean> getEmployeesSummaries() {
        final List<Employee> employeesList=this.employeeManager.getAllEmployee();
        final List<EmployeeViewBean> employeeViewBeans=new ArrayList<>(employeesList.size());
        for(Employee employee:employeesList){
            employeeViewBeans.add(new EmployeeViewBean(employee));
        }
        return employeeViewBeans;
    }


    // http://localhost:8080/SpringRestJsonViewSecurityTokenAuthentication/employee/{employeeId}/data
    @RequestMapping("/employee/{employeeId}/data")
    @ResponseView(EmployeeView.class)
    public
    @ResponseBody
    EmployeeViewBean getSummary(@PathVariable("employeeId") Integer employeeId) {
        return new EmployeeViewBean(this.employeeManager.getEmployee(employeeId));
    }

    // http://localhost:8080/SpringRestJsonViewSecurityTokenAuthentication/employee/{employeeId}
    @RequestMapping("/employee/{employeeId}")
    public
    @ResponseBody
    EmployeeViewBean getEmployeeDetail(@PathVariable("employeeId") Integer employeeId) {
        return new EmployeeViewBean(this.employeeManager.getEmployee(employeeId));
    }


    // http://localhost:8080/SpringRestJsonViewSecurityTokenAuthentication/employee/detail/all
    @RequestMapping("/employee/detail/all")
    @ResponseView(EmployeeDetailView.class)
    public
    @ResponseBody
    List<EmployeeViewBean> getEmployeesDetailSummary() {
        final List<Employee> employeesList=this.employeeManager.getAllEmployee();
        final List<EmployeeViewBean> employeeViewBeans=new ArrayList<>(employeesList.size());
        for(Employee employee:employeesList){
            employeeViewBeans.add(new EmployeeViewBean(employee));
        }
        return employeeViewBeans;
    }


    // http://localhost:8080/SpringRestJsonViewSecurityTokenAuthentication/employee/detail/{employeeId}/data
    @RequestMapping("/employee/detail/{employeeId}/data")
    @ResponseView(EmployeeDetailView.class)
    public
    @ResponseBody
    EmployeeViewBean getDetailSummary(@PathVariable("employeeId") Integer employeeId) {
        return new EmployeeViewBean(this.employeeManager.getEmployee(employeeId));
    }

}
