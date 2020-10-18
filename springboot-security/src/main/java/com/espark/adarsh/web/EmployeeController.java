package com.espark.adarsh.web;

import com.espark.adarsh.bean.ApiResponseBean;
import com.espark.adarsh.entity.Employee;
import com.espark.adarsh.exception.ResourceNotFound;
import com.espark.adarsh.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public ApiResponseBean<List<Employee>> getAllEmployee() throws ResourceNotFound {
        ApiResponseBean apiResponseBean = new ApiResponseBean();
        apiResponseBean.setData(this.employeeService.getAllEmployee());
        apiResponseBean.setMessage("All User Fetched Successfully");
        return apiResponseBean;
    }

    @GetMapping("/employee/{id}")
    public ApiResponseBean<Employee> getEmployee(@PathVariable("id") Long id) throws ResourceNotFound {
        ApiResponseBean apiResponseBean = new ApiResponseBean();
        apiResponseBean.setData(this.employeeService.getEmployee(id));
        apiResponseBean.setMessage("User Fetched Successfully");
        return apiResponseBean;
    }

    @DeleteMapping("/employees/{id}")
    public ApiResponseBean<Employee> removeEmployee(@PathVariable("id") Long id) throws ResourceNotFound {
        ApiResponseBean apiResponseBean = new ApiResponseBean();
        apiResponseBean.setData(this.employeeService.removeEmployee(id));
        apiResponseBean.setMessage("User Deleted Successfully");
        return apiResponseBean;
    }

    @PostMapping("/employee")
    public ApiResponseBean<Employee> saveEmployee(@RequestBody Employee employee) {
        ApiResponseBean apiResponseBean = new ApiResponseBean();
        apiResponseBean.setData(this.employeeService.saveEmployee(employee));
        apiResponseBean.setMessage("User Created Successfully");
        return apiResponseBean;
    }

    @PostMapping("/employee/{id}")
    public ApiResponseBean<Employee> updateEmployee(@PathVariable("id") Long id,
                                                    @RequestBody Employee employee) throws ResourceNotFound {
        ApiResponseBean apiResponseBean = new ApiResponseBean();
        apiResponseBean.setData(this.employeeService.updateEmployee(id, employee));
        apiResponseBean.setMessage("User Updated Successfully");
        return apiResponseBean;
    }

}