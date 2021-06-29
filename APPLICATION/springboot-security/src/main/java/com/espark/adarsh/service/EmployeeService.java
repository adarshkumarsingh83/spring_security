package com.espark.adarsh.service;

import com.espark.adarsh.bean.EmployeeBean;
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

    public List<EmployeeBean> getAllEmployee() throws ResourceNotFound {
        if (this.employeeRepository.count() > 0) {
            List<EmployeeBean> employeeList = this.employeeRepository.findAll()
                    .stream()
                    .map(employee -> employee.getEmployeeBean())
                    .collect(Collectors.toList());
            return employeeList;
        } else {
            throw new ResourceNotFound("employee db is empty");
        }
    }

    public EmployeeBean getEmployee(Long id) throws ResourceNotFound {
        if (this.employeeRepository.existsById(id)) {
            return this.employeeRepository.findById(id).get().getEmployeeBean();
        } else {
            throw new ResourceNotFound("user not found with " + id);
        }
    }

    public EmployeeBean removeEmployee(Long id) throws ResourceNotFound {
        if (this.employeeRepository.existsById(id)) {
            Employee employee = this.employeeRepository.findById(id).get();
            this.employeeRepository.deleteById(id);
            return employee.getEmployeeBean();
        } else {
            throw new ResourceNotFound("user not found with " + id);
        }
    }

    public EmployeeBean saveEmployee(Employee employee) {
        return this.employeeRepository.save(employee).getEmployeeBean();
    }

    public EmployeeBean updateEmployee(Long id, Employee employee) throws ResourceNotFound {
        if (this.employeeRepository.existsById(id)) {
            return this.employeeRepository.save(employee).getEmployeeBean();
        } else {
            throw new ResourceNotFound("user not found with " + id);
        }
    }

}