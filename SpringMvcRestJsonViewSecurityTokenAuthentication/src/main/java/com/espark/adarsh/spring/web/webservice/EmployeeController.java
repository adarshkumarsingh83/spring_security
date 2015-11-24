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

    // http://localhost:8080/SpringMvcRestJsonViewSecurityTokenAuthentication/employee
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


    // http://localhost:8080/SpringMvcRestJsonViewSecurityTokenAuthentication/employee/all
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


    // http://localhost:8080/SpringMvcRestJsonViewSecurityTokenAuthentication/employee/{employeeId}/data
    @RequestMapping("/employee/{employeeId}/data")
    @ResponseView(EmployeeView.class)
    public
    @ResponseBody
    EmployeeViewBean getSummary(@PathVariable("employeeId") Integer employeeId) {
        return new EmployeeViewBean(this.employeeManager.getEmployee(employeeId));
    }

    // http://localhost:8080/SpringMvcRestJsonViewSecurityTokenAuthentication/employee/{employeeId}
    @RequestMapping("/employee/{employeeId}")
    public
    @ResponseBody
    EmployeeViewBean getEmployeeDetail(@PathVariable("employeeId") Integer employeeId) {
        return new EmployeeViewBean(this.employeeManager.getEmployee(employeeId));
    }


    // http://localhost:8080/SpringMvcRestJsonViewSecurityTokenAuthentication/employee/detail/all
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


    // http://localhost:8080/SpringMvcRestJsonViewSecurityTokenAuthentication/employee/detail/{employeeId}/data
    @RequestMapping("/employee/detail/{employeeId}/data")
    @ResponseView(EmployeeDetailView.class)
    public
    @ResponseBody
    EmployeeViewBean getDetailSummary(@PathVariable("employeeId") Integer employeeId) {
        return new EmployeeViewBean(this.employeeManager.getEmployee(employeeId));
    }

}
