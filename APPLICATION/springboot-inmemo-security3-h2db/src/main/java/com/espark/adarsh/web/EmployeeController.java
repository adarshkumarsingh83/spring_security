package com.espark.adarsh.web;

import com.espark.adarsh.entity.Employee;
import com.espark.adarsh.exception.EmployeeNotFoundException;
import com.espark.adarsh.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = new LinkedList<>();
        this.employeeRepository.findAll().forEach(employee -> employeeList.add(employee));
        return employeeList;
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") Long id) {
        return this.employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("employee not found"));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/employee/{id}")
    public Employee removeEmployee(@PathVariable("id") Long id) {
        Employee employee = this.employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("employee not found"));
        this.employeeRepository.deleteById(id);
        return employee;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        return this.employeeRepository.save(employee);
    }

}
