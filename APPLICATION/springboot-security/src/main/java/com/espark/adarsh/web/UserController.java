package com.espark.adarsh.web;

import com.espark.adarsh.bean.ApiResponseBean;
import com.espark.adarsh.bean.UserBean;
import com.espark.adarsh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/user/{id}")
    public ApiResponseBean<UserBean> getUserById(@PathVariable("id") Long id) {
        return new ApiResponseBean<UserBean>(userService.getUserById(id), "user fetch successfully", null);
    }

    @GetMapping(value = "/users")
    public ApiResponseBean<List<UserBean>> getUsers() {
        return new ApiResponseBean<List<UserBean>>(userService.getUsers(), "users fetch successfully", null);
    }

    @PostMapping(value = "/user")
    public ApiResponseBean<UserBean> saveUser(@RequestBody UserBean userBean) {
        return new ApiResponseBean<UserBean>(userService.createUser(userBean), "user created successfully", null);
    }

    @PutMapping(value = "/user/{id}")
    public ApiResponseBean<UserBean> updateUser(@PathVariable("id") Long id, @RequestBody UserBean userBean) {
        return new ApiResponseBean<UserBean>(userService.updateUser(userBean), "user updated successfully", null);
    }


    @DeleteMapping(value = "/user/{id}")
    public ApiResponseBean<UserBean> deleteUser(@PathVariable("id") Long id) {
        return new ApiResponseBean<UserBean>(userService.deleteUser(id), "user deleted successfully", null);
    }
}
