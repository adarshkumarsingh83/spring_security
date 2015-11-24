/*
 * Copyright ©Adarsh Development Services
 * All Rights Reserved.
 */
package com.adarsh.spring.persistence.entity;


import org.codehaus.jackson.annotate.JsonPropertyOrder;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 1/1/13 00:11 AM#$
 */
@Entity
@Table(name = "user_roles")
@XmlRootElement(name = "user_roles")
@XmlType(propOrder = {"id", "roleName"})
@JsonPropertyOrder({"id", "roleName"})
public class UserRole {

    @Id
    @XmlElement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="roleId" ,insertable = true, nullable = false, unique = true, updatable = true)
    protected Integer id;

    @XmlElement
    @Column(nullable = false, length = 40)
    private String roleName;

    public UserRole() {
    }

    public UserRole(String roleName) {
        this.roleName = roleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
