package com.adarsh.spring.resteasy.bean;



import com.adarsh.spring.resteasy.persistance.entity.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by scorpio_wolfpack on 5/3/15.
 */
public class UserBean implements Serializable{

    private Integer id;

    private String login;

    private String password;

    public UserBean() {
    }

    public UserBean(User user) {
        this.id=user.getId();
        this.login=user.getLogin();
        this.password=user.getPassword();
    }

    public static List<UserBean> getUserBeanList(List<User> userList){
        final List<UserBean> userBeans=new ArrayList<UserBean>();
        for(User user:userList){
            userBeans.add(new UserBean(user));
        }
        return userBeans;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
