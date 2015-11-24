/*
 * Copyright ©Adarsh Development Services
 * All Rights Reserved.
 */
package com.adarsh.spring.persistence.entity;


import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 1/1/13 00:11 AM#$
 */
@Entity
@Table(name = "users")
@XmlRootElement(name = "users")
@XmlType(propOrder = {"id","firstName","lastName","userName", "password","email", "phoneNumber"})
@JsonPropertyOrder({"id", "firstName","lastName","userName", "password","email", "phoneNumber"})
public class User {

    @Id
    @XmlElement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="userId" ,insertable = true, nullable = false, unique = true, updatable = true)
    protected Integer id;

    @XmlElement
    @Column(unique = true, length = 24, nullable = false)
    private String userName;

    @XmlElement
    @Column(length = 100, nullable = false)
    private String email;

    @XmlElement
    @Column(length = 100, nullable = false)
    private String password;

    @XmlElement
    @Column(nullable = false)
    private Boolean enabled=Boolean.TRUE;

    @XmlElement
    @Column(length = 24, nullable = false)
    private String firstName;

    @XmlElement
    @Column(length = 24, nullable = true)
    private String lastName;

    @XmlElement
    @Column(length = 12, nullable = false)
    private String phoneNumber;

    @XmlElement
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(name = "user_role_mapping")
    private Set<UserRole> roles = new HashSet<UserRole>();

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(UserRole role) {
        this.roles.add(role);
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonIgnore
    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", roles=" + roles +
                '}';
    }
}
