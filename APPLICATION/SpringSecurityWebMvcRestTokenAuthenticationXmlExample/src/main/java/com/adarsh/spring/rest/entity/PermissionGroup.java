/*
 * Copyright (c) 2015 Espark And ©Adarsh Development Services @copyright All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Espark nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
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
 * @Espark @copyright all right reserve
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
