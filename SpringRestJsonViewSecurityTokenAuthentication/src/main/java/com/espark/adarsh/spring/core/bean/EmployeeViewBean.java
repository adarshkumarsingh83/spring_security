package com.espark.adarsh.spring.core.bean;

import com.espark.adarsh.spring.core.bean.view.EmployeeDetailView;
import com.espark.adarsh.spring.core.bean.view.EmployeeView;
import com.espark.adarsh.spring.persistence.entities.Employee;
import com.espark.adarsh.spring.web.persentation.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
public class EmployeeViewBean implements Serializable {

    private Employee employee;

    public EmployeeViewBean() {
    }

    public EmployeeViewBean(Employee employee) {
        this.employee = employee;
    }

    @JsonView({EmployeeDetailView.class, EmployeeView.class})
    public Long getEmployeeId() {
        return this.employee.getEmployeeId();
    }

    public void setEmployeeId(Long employeeId) {
        this.employee.setEmployeeId(employeeId);
    }

    @JsonView({EmployeeDetailView.class, EmployeeView.class})
    public String getEmployeeName() {
        return this.employee.getEmployeeName();
    }

    public void setEmployeeName(String employeeName) {
        this.employee.setEmployeeName(employeeName);
    }

    @JsonView({EmployeeDetailView.class, EmployeeView.class})
    public String getEmployeeEmail() {
        return this.employee.getEmployeeEmail();
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employee.setEmployeeEmail(employeeEmail);
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonView({EmployeeDetailView.class, EmployeeView.class})
    public Date getDateOfJoining() {
        return this.employee.getDateOfJoining();
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.employee.setDateOfJoining(dateOfJoining);
    }

    @JsonView({EmployeeDetailView.class})
    public DepartmentViewBean getDepartment() {
        return new DepartmentViewBean(this.employee.getDepartment());
    }

}
