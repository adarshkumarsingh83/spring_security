package com.espark.adarsh.db;

import com.espark.adarsh.entity.Employee;
import com.espark.adarsh.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {


    @Autowired
    EmployeeRepository repository;

    @PostConstruct
    public void init() {
        repository.save(new Employee("Radha", "Singh"));
        repository.save(new Employee("Adarsh", "kumar"));
        repository.save(new Employee("Amit", "kumar"));
        repository.save(new Employee("Chloe", "O'Brian"));
        repository.save(new Employee("Kim", "Bauer"));
        repository.save(new Employee("David", "Palmer"));
        repository.save(new Employee("Michelle", "Dessler"));
    }

}
