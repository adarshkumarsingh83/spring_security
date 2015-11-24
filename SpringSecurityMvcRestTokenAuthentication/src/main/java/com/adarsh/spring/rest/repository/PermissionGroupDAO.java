
package com.adarsh.spring.rest.repository;


import com.adarsh.spring.rest.entity.PermissionGroup;

import java.text.ParseException;
import java.util.List;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
public interface PermissionGroupDAO {
	
	List<PermissionGroup> getAllPermissionGroups(List<Long> groupId);
	
	PermissionGroup getPermissionGroupByName(String permissionGroupName);

	List<PermissionGroup> getUserPermissionGroupsByUsername(String username);

    List<String> getPermissionGroupNames() throws ParseException;
}
