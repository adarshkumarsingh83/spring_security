package com.espark.adarsh.bean;

import com.espark.adarsh.entity.Employee;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class EmployeeBean implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String career;

    public EmployeeBean(Employee employee){
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.career = employee.getCareer();

    }
}
