package com.espark.adarsh.web;

import com.espark.adarsh.bean.ApiResponseBean;
import com.espark.adarsh.bean.EmployeeBean;
import com.espark.adarsh.entity.Employee;
import com.espark.adarsh.exception.ResourceNotFound;
import com.espark.adarsh.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
@Api(value = "EmployeeController", description = "Employee Operations")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @ApiOperation(value = "Employee", nickname = "employee", notes = "Return the List of the Employee")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful Response Send"),
            @ApiResponse(code = 404, message = "Employees not found")
            , @ApiResponse(code = 500, message = "Server Error")})
    @GetMapping("/employees")
    public ApiResponseBean<List<EmployeeBean>> getAllEmployee() throws ResourceNotFound {
        ApiResponseBean apiResponseBean = new ApiResponseBean();
        apiResponseBean.setData(this.employeeService.getAllEmployee());
        apiResponseBean.setMessage("All User Fetched Successfully");
        return apiResponseBean;
    }

    @ApiOperation(value = "Employee", nickname = "employee", notes = "Return the the Employee based on EmpId")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Employee not found")
            , @ApiResponse(code = 500, message = "Server Error")})
    @GetMapping("/employee/{id}")
    public ApiResponseBean<EmployeeBean> getEmployee(@PathVariable("id") Long id) throws ResourceNotFound {
        ApiResponseBean apiResponseBean = new ApiResponseBean();
        apiResponseBean.setData(this.employeeService.getEmployee(id));
        apiResponseBean.setMessage("User Fetched Successfully");
        return apiResponseBean;
    }

    @ApiOperation(value = "Employee", nickname = "employee", notes = "Delete the Employee")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Employee not found")
            , @ApiResponse(code = 500, message = "Server Error")})
    @DeleteMapping("/employees/{id}")
    public ApiResponseBean<EmployeeBean> removeEmployee(@PathVariable("id") Long id) throws ResourceNotFound {
        ApiResponseBean apiResponseBean = new ApiResponseBean();
        apiResponseBean.setData(this.employeeService.removeEmployee(id));
        apiResponseBean.setMessage("User Deleted Successfully");
        return apiResponseBean;
    }

    @ApiOperation(value = "Employee", nickname = "employee", notes = "Create the Employee")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Employee Exist")
            , @ApiResponse(code = 404, message = "Employee Exist")
            , @ApiResponse(code = 500, message = "Server Error")
            , @ApiResponse(code = 200, message = "Employee Created", responseContainer = "EsparkResponseBean")})
    @PostMapping("/employee")
    public ApiResponseBean<EmployeeBean> saveEmployee(@RequestBody Employee employee) {
        ApiResponseBean apiResponseBean = new ApiResponseBean();
        apiResponseBean.setData(this.employeeService.saveEmployee(employee));
        apiResponseBean.setMessage("User Created Successfully");
        return apiResponseBean;
    }

    @ApiOperation(value = "Employee", nickname = "employee", notes = "Update the Employee")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Employee Not Exist")
            , @ApiResponse(code = 404, message = "Employee not Exist")
            , @ApiResponse(code = 500, message = "Server Error")
            , @ApiResponse(code = 200, message = "Employee Updated", responseContainer = "EsparkResponseBean")})
    @PutMapping("/employee/{id}")
    public ApiResponseBean<EmployeeBean> updateEmployee(@PathVariable("id") Long id,
                                                    @RequestBody Employee employee) throws ResourceNotFound {
        ApiResponseBean apiResponseBean = new ApiResponseBean();
        apiResponseBean.setData(this.employeeService.updateEmployee(id, employee));
        apiResponseBean.setMessage("User Updated Successfully");
        return apiResponseBean;
    }

}