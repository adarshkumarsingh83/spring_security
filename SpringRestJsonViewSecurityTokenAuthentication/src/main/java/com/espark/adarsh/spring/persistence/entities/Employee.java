package com.espark.adarsh.spring.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="employeeId" ,insertable = true, nullable = false, unique = true, updatable = true)
    private Long employeeId;

    @Column(unique = true, length = 24, nullable = false)
    private String employeeName;

    @Column(unique = true, length = 24, nullable = false)
    private String employeeEmail;

    @Column(name="dateOfJoining")
    private Date dateOfJoining;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(name = "employee_department_mapping")
    private Set<Department> department = new HashSet<Department>();


    public Employee() {
    }

    public Employee(Long employeeId, String employeeName, String employeeEmail) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
    }

    public Employee(Long employeeId, String employeeName, String employeeEmail, Date dateOfJoining, Department department) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.dateOfJoining = dateOfJoining;
        this.department.add(department);
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Department getDepartment() {
        return department.iterator().next();
    }

    public void setDepartment(Department department) {
        this.department.add(department);
    }
}
