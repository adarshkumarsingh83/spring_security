package com.espark.adarsh.bean;

import lombok.*;

@Data
@Setter
@Getter
@ToString
public class Employee {

    private Long id;

    private String firstName;

    private String lastName;

    public Employee() {
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}