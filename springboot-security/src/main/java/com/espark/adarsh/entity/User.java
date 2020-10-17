package com.espark.adarsh.entity;


import com.espark.adarsh.bean.UserBean;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String password;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private List<UserRole> roles = new LinkedList<>();


    public void setUserRole(UserRole role) {
        this.roles.add(role);
    }


    public UserBean getUserBean() {
        UserBean userBean = new UserBean();
        List<String> roles = this.getRoles()
                .stream()
                .map(userRole -> userRole.getRoleName())
                .collect(Collectors.toList());
        userBean.setId(this.getId());
        userBean.setUserName(this.getUserName());
        userBean.setUserRoles(roles);
        return userBean;
    }
}
