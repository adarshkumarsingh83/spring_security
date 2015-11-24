package com.adarsh.spring.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.*;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
@Entity
@Table(name = "users")
@JsonPropertyOrder({"userId", "userId","lastName","userName","password","emailAddress"})
public class User implements java.io.Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "username", unique = true, length = 100)
    private String userName;

    @Column(name = "password", length = 500)
    private String password;

    @Column(name = "email_address", length = 100)
    private String emailAddress;

    @Transient
    private Set<Permission> permissionsSet = new HashSet<Permission>();

    @JsonIgnore
    @ManyToMany(targetEntity = PermissionGroup.class
            , cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_permission_group"
            , joinColumns = {@JoinColumn(name = "user_id")}
            , inverseJoinColumns = {@JoinColumn(name = "permission_group_id")})
    private List<PermissionGroup> userPermissionGroupList = new ArrayList<PermissionGroup>();


    public User() {
    }

    public User(String userName) {
        this();
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<PermissionGroup> getUserPermissionGroupList() {
        return userPermissionGroupList;
    }

    public void setUserPermissionGroupList(List<PermissionGroup> userPermissionGroupList) {
        this.userPermissionGroupList = userPermissionGroupList;
    }

    public Set<Permission> getPermissionsSet() {
        return permissionsSet;
    }

    public void setPermissionsSet(Set<Permission> permissionsSet) {
        this.permissionsSet = permissionsSet;
    }
}
