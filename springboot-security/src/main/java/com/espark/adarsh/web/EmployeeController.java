package com.espark.adarsh.web;

import com.espark.adarsh.bean.ApiResponseBean;
import com.espark.adarsh.entity.Employee;
import com.espark.adarsh.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public ApiResponseBean<List<Employee>> getAllEmployee() {
        List<Employee> employeeList = new LinkedList<>();
        ApiResponseBean apiResponseBean = new ApiResponseBean();
        apiResponseBean.setData(this.employeeService.getAllEmployee());
        return apiResponseBean;
    }

    @GetMapping("/employee/{id}")
    public ApiResponseBean<Employee> getEmployee(@PathVariable("id") Long id) {
        ApiResponseBean apiResponseBean = new ApiResponseBean();
        apiResponseBean.setData(this.employeeService.getEmployee(id));
        return apiResponseBean;
    }

    @DeleteMapping("/employees/{id}")
    public ApiResponseBean<Employee> removeEmployee(@PathVariable("id") Long id) {
        ApiResponseBean apiResponseBean = new ApiResponseBean();
        apiResponseBean.setData(this.employeeService.removeEmployee(id));
        return apiResponseBean;
    }

    @PostMapping("/employee")
    public ApiResponseBean<Employee> saveEmployee(@RequestBody Employee employee) {
        ApiResponseBean apiResponseBean = new ApiResponseBean();
        apiResponseBean.setData(this.employeeService.saveEmployee(employee));
        return apiResponseBean;
    }

    @PostMapping("/employee/{id}")
    public ApiResponseBean<Employee> updateEmployee(@PathVariable("id") Long id,
                                                    @RequestBody Employee employee) {
        ApiResponseBean apiResponseBean = new ApiResponseBean();
        apiResponseBean.setData(this.employeeService.updateEmployee(id, employee));
        return apiResponseBean;
    }

}