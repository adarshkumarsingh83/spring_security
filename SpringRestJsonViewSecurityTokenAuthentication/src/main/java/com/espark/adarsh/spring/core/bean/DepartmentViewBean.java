package com.espark.adarsh.spring.core.bean;

import com.espark.adarsh.spring.core.bean.view.DepartmentView;
import com.espark.adarsh.spring.core.bean.view.EmployeeDetailView;
import com.espark.adarsh.spring.persistence.entities.Department;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
public class DepartmentViewBean implements Serializable {

    private Department department;

    public DepartmentViewBean() {
    }

    public DepartmentViewBean(Department department) {
        this.department = department;
    }

    @JsonView({EmployeeDetailView.class, DepartmentView.class})
    public Long getDepartmentId() {
        return this.department.getDepartmentId();
    }

    public void setDepartmentId(Long departmentId) {
        this.department.setDepartmentId(departmentId);
    }

    @JsonView({EmployeeDetailView.class, DepartmentView.class})
    public String getDepartmentName() {
        return this.department.getDepartmentName();
    }

    public void setDepartmentName(String departmentName) {
        this.department.setDepartmentName(departmentName);
    }

    @JsonView({EmployeeDetailView.class, DepartmentView.class})
    public String getDepartmentLocation() {
        return this.department.getDepartmentLocation();
    }

    public void setDepartmentLocation(String departmentLocation) {
        this.department.setDepartmentLocation(departmentLocation);
    }

}
