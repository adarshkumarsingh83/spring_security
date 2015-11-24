package com.adarsh.spring.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
@Entity
@Table(name = "permission_group")
public class PermissionGroup implements java.io.Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_group_id")
    private Long permissionGroupId;

    @Column(name = "permission_group_name", unique = true)
    private String permissionGroupName;

    @ManyToMany(targetEntity = com.adarsh.spring.rest.entity.Permission.class
            , cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "permission_group_permission"
            , joinColumns = {@JoinColumn(name = "permission_group_id")}
            , inverseJoinColumns = {@JoinColumn(name = "permission_id")})
    private List<Permission> permissionGroupPermissionList = new ArrayList<Permission>();

    @Transient
    private Set<Permission> permissionsSet = new HashSet<Permission>();

    @ManyToMany(targetEntity = com.adarsh.spring.rest.entity.User.class
            , cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_permission_group"
            , joinColumns = {@JoinColumn(name = "permission_group_id")}
            , inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> userSet = new HashSet<User>();

    public PermissionGroup() {
    }


    public Long getPermissionGroupId() {
        return permissionGroupId;
    }

    public void setPermissionGroupId(Long permissionGroupId) {
        this.permissionGroupId = permissionGroupId;
    }

    public String getPermissionGroupName() {
        return permissionGroupName;
    }

    public void setPermissionGroupName(String permissionGroupName) {
        this.permissionGroupName = permissionGroupName;
    }

    public List<Permission> getPermissionGroupPermissionList() {
        return permissionGroupPermissionList;
    }

    public void setPermissionGroupPermissionList(List<Permission> permissionGroupPermissionList) {
        this.permissionGroupPermissionList = permissionGroupPermissionList;
    }

    public Set<Permission> getPermissionsSet() {
        permissionsSet.addAll(permissionGroupPermissionList);
        return permissionsSet;
    }

    public void setPermissionsSet(Set<Permission> permissionsSet) {
        this.permissionsSet = permissionsSet;
    }


    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }
}
