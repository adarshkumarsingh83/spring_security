package com.espark.adarsh.service;

import com.espark.adarsh.entity.Employee;
import com.espark.adarsh.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = new LinkedList<>();
        this.employeeRepository.findAll().forEach(employee -> employeeList.add(employee));
        return employeeList;
    }

    public Employee getEmployee(Long id) {
        return this.employeeRepository.findById(id).get();
    }

    public Employee removeEmployee(Long id) {
        Employee employee = this.employeeRepository.findById(id).get();
        this.employeeRepository.deleteById(id);
        return employee;
    }

    public Employee saveEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        return this.employeeRepository.save(employee);
    }

}