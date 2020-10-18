package com.espark.adarsh.service;

import com.espark.adarsh.entity.Employee;
import com.espark.adarsh.exception.ResourceNotFound;
import com.espark.adarsh.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() throws ResourceNotFound {
        if (this.employeeRepository.count() > 0) {
            List<Employee> employeeList = this.employeeRepository.findAll()
                    .stream()
                    .collect(Collectors.toList());
            return employeeList;
        } else {
            throw new ResourceNotFound("employee db is empty");
        }
    }

    public Employee getEmployee(Long id) throws ResourceNotFound {
        if (this.employeeRepository.existsById(id)) {
            return this.employeeRepository.findById(id).get();
        } else {
            throw new ResourceNotFound("user not found with " + id);
        }
    }

    public Employee removeEmployee(Long id) throws ResourceNotFound {
        if (this.employeeRepository.existsById(id)) {
            Employee employee = this.employeeRepository.findById(id).get();
            this.employeeRepository.deleteById(id);
            return employee;
        } else {
            throw new ResourceNotFound("user not found with " + id);
        }
    }

    public Employee saveEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) throws ResourceNotFound {
        if (this.employeeRepository.existsById(id)) {
            return this.employeeRepository.save(employee);
        } else {
            throw new ResourceNotFound("user not found with " + id);
        }
    }

}