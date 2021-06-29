package com.espark.adarsh.entity;

import com.espark.adarsh.bean.EmployeeBean;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String email;
    private String profession;

    public Employee() {
    }

    public Employee(String firstName, String lastName,String email, String profession) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.profession = profession;
    }

    public Employee(Long id, String firstName, String lastName,String email, String profession) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.profession = profession;
    }

    @JsonIgnore
    public EmployeeBean getEmployeeBean() {
        return new EmployeeBean(this.id, this.firstName, this.lastName,this.email, this.profession);
    }

}
