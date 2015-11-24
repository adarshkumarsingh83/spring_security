package com.adarsh.spring.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang.builder.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
@Entity
@Table(name = "permission")
public class Permission implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
	private Long permissionId;

    @Column(name = "permission_name", unique = true)
	private String permissionName;

    @Column(name = "permission_category")
	private String permissionCategory;

    @ManyToMany(mappedBy = "permissionGroupPermissionList"
            , targetEntity = com.adarsh.spring.rest.entity.PermissionGroup.class
            , cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<PermissionGroup> permissionGroupSet = new HashSet<PermissionGroup>();

	
	public Permission() {
	}

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionCategory() {
        return permissionCategory;
    }

    public void setPermissionCategory(String permissionCategory) {
        this.permissionCategory = permissionCategory;
    }

    public Set<PermissionGroup> getPermissionGroupSet() {
        return permissionGroupSet;
    }

    public void setPermissionGroupSet(Set<PermissionGroup> permissionGroupSet) {
        this.permissionGroupSet = permissionGroupSet;
    }

}
