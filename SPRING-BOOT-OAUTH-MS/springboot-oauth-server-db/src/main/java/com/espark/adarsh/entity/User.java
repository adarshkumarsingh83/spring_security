package com.espark.adarsh.entity;

import javax.persistence.Entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "enabled")
    private Boolean enabled;
    @Column(name = "accountNonExpired")
    private Boolean accountNonExpired;
    @Column(name = "credentialsNonExpired")
    private Boolean credentialsNonExpired;
    @Column(name = "accountNonLocked")
    private Boolean accountNonLocked;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_user", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

    public User() {
    }

    public User(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.enabled = user.enabled;
        this.accountNonExpired = user.accountNonExpired;
        this.credentialsNonExpired = user.credentialsNonExpired;
        this.accountNonLocked = user.accountNonLocked;
        this.roles = user.getRoles();
    }

}