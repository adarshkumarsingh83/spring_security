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

    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).get();
    }

    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = new LinkedList<>();
        employeeRepository
                .findAll()
                .forEach(employee -> employeeList.add(employee));
        return employeeList;
    }

    public Employee createEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    public Employee deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return employee;
    }

}
