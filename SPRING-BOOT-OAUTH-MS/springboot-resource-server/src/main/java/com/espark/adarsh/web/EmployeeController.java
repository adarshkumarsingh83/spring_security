package com.espark.adarsh.web;

import com.espark.adarsh.entity.Employee;
import com.espark.adarsh.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    @PreAuthorize("hasRole('ADMIN') or hasRole('ROLE_ADMIN')")
    public List<Employee> getAll() {
        return this.employeeService.getAllEmployee();
    }

    @GetMapping("/employee/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Employee getEmployee(@PathVariable("id") Long id) {
        return this.employeeService.getEmployee(id);
    }

    @PutMapping("/employee/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('ROLE_ADMIN')")
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        return this.employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employee/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('ROLE_ADMIN')")
    public Employee deleteEmployee(@PathVariable("id") Long id) {
        return this.employeeService.deleteEmployee(id);
    }

    @PostMapping("/employee")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Employee getEmployee(@RequestBody Employee employee) {
        return this.employeeService.createEmployee(employee);
    }

}
