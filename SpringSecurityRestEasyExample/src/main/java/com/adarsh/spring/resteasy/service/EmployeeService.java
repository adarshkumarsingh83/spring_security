package com.adarsh.spring.resteasy.service;

import com.adarsh.spring.resteasy.bean.Employee;

import java.util.List;

/**
 * Created by Adarsh on 5/4/15.
 */
public interface EmployeeService {

    public List<Employee> getEmployee();
}
