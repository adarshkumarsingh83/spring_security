/*
 * Copyright (c) Sourcen Inc. 2004-2012
 * All rights reserved.
 */

package com.adarsh.spring.entity.impl;


import com.adarsh.spring.entity.construct.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */

@Entity
@Table(name = "UserRole")
public final class UserRole extends AbstractEntity<Long> {

    @Column(nullable = false, length = 100)
    private String name;

    public UserRole() {
        super(UserRole.class);
    }

    public UserRole(String name) {
        super(UserRole.class);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "name='" + name + '\'' +
                '}';
    }
}
