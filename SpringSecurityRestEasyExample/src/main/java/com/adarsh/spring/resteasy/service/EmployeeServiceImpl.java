
package com.adarsh.spring.resteasy.service;

import com.adarsh.spring.resteasy.bean.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adarsh on 5/4/15.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public List<Employee> getEmployee() {

        return new ArrayList<Employee>(){
            {
                add(new Employee(101,"adarsh","adarsh@kumar"));
                add(new Employee(102,"radha","radha@singh"));
                add(new Employee(103,"amit","amit@kuamar"));
            }
        };
    }
}
