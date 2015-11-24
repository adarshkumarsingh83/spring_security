package com.adarsh.spring.entity;


import java.util.HashSet;
import java.util.Set;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */


public final class User {

    private Long userId;
    private String userName;
    private String userPwd;
    private boolean enable;
    private Set<UserRole> userRoles;

    {
        userRoles = new HashSet<UserRole>();
    }

    public User() {
    }

    public User(Long id) {
        userId = id;
    }

    public User(String userName) {
        this.userName = userName;
        userRoles = new HashSet<UserRole>();
    }

    public User(Long userId, String userName, String userPwd, boolean enable, UserRole userRole) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.enable = enable;
        this.userRoles.add(userRole);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public boolean getEnable() {
        return enable;
    }

    public void setEnable(boolean val) {
        this.enable = true;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRole(UserRole userRole) {
        this.userRoles.add(userRole);
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

}
