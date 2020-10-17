package com.espark.adarsh.entity;

import com.espark.adarsh.bean.EmployeeBean;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String career;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String career) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.career = career;
    }

    public Employee(Long id, String firstName, String lastName, String career) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.career = career;
    }

    public EmployeeBean getEmployeeBean() {
        return new EmployeeBean(this.id, this.firstName, this.lastName, this.career);
    }

}
