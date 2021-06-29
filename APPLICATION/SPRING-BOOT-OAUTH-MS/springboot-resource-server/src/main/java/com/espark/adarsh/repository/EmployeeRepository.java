package com.espark.adarsh.repository;

import java.util.List;

import com.espark.adarsh.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findByLastName(String lastName);

    Employee findById(long id);
}