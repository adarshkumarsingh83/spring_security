package com.adarsh.spring.entity.impl;


import com.adarsh.spring.entity.construct.AbstractEntity;
import org.springframework.util.DigestUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */

@Entity
@Table(name = "User")
public final class User extends AbstractEntity<Long> {

    @Column(unique = true, length = 24, nullable = false)
    private String userName;

    @Column(length = 100, nullable = false)
    private String userEmail;


    @Column(length = 100, nullable = false)
    private String userPwd;

    @Column(length = 10, nullable = true)
    private String userPhone;

    @Column(nullable = false)
    private Boolean enabled;


    @Column(length = 24, nullable = false)
    private String firstName;

    @Column(length = 24, nullable = true)
    private String lastName;


    @Column
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date modifiedDate;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role_mapping")
    private Set<UserRole> userRoles;



    public User() {
        super(User.class);
    }

    public User(Long id) {
        super(User.class);
        super.setId(id);
        this.setUserName("");
    }


    public User(String userName) {
        this();
        this.userName = userName;
    }

    public User(User user) {
        super(User.class);
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.userEmail = user.getUserEmail();
        this.enabled = user.getEnabled();
        this.userName = user.getUserName();
        this.setUserPwd(user.getUserPwd());
        this.userPhone = user.getUserPhone();
        this.setUserRoles(user.getUserRoles());
        this.setModifiedDate(new Date());
        this.setCreatedDate(new Date());
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = DigestUtils.md5DigestAsHex(userPwd.getBytes());
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public void setRole(UserRole roles) {
        if (userRoles == null) {
            userRoles = new HashSet<UserRole>();
        }
        this.userRoles.add(roles);
    }



    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", enabled=" + enabled +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", userRoles=" + userRoles.iterator().next().getName() +
                '}';
    }
}
