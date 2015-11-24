package com.adarsh.spring.rest.security;


import com.adarsh.spring.rest.entity.Permission;
import com.adarsh.spring.rest.entity.User;
import com.adarsh.spring.rest.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
@Service(value = "customUserDetailsService")
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Qualifier("userService")
    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException, DataAccessException {
        logger.debug("DbUserDetailsService loadUserByUsername() ");
        try {
            final User user = this.userService.getUser(userName);

            if (user == null) {
                throw new BadCredentialsException("Username not found");
            }
            final Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
            final Set<Permission> permissionsSet = user.getPermissionsSet();
            if (!CollectionUtils.isEmpty(permissionsSet)) {
                for (Permission permission : permissionsSet) {
                    logger.debug("PermissionName-{}", permission);
                    authorities.add(new SimpleGrantedAuthority(permission.getPermissionName()));
                }
            }
            return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
        } catch (Exception e) {
            logger.error("Unable to find record with username:=" + userName, e);
        }
        return null;
    }
}
