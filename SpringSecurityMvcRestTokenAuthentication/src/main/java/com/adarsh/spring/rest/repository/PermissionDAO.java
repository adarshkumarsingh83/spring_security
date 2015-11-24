package com.adarsh.spring.rest.repository;


import com.adarsh.spring.rest.entity.Permission;

import java.util.List;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
public interface PermissionDAO {
	
	public List<Permission> getAllPermissions();
	
	public List<Permission> getPermission(List<Long> permissionId);

	public List<Permission> getUserPermissionsByPermissionGroupName(
            String permissionGroupName);
	
	public Permission getPermissionByName(String permissionName);
	
}
