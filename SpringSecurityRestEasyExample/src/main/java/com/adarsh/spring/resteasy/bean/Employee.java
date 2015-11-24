package com.adarsh.spring.resteasy.bean;

import java.io.Serializable;

/**
 * Created by Adarsh on 5/4/15.
 */
public class Employee implements Serializable{

    private Integer empId;
    private String empName;
    private String empEmail;

    public Employee() {
    }

    public Employee(Integer empId, String empName, String empEmail) {
        this.empId = empId;
        this.empName = empName;
        this.empEmail = empEmail;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    @Override
    public String toString() {
        return "{" +
                "empId:" + empId +
                ", empName:" + empName +
                ", empEmail:" + empEmail +
                "}";
    }
}
