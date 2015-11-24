package com.adarsh.spring.web.security;

import com.adarsh.spring.persistence.entity.User;
import com.adarsh.spring.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 1/1/13 00:11 AM#$
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private static final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();
    @Autowired(required = true)
    private final UserService userService = null;

    @Qualifier(value = "userDetailsServiceInMemo")
    @Autowired(required = true)
    private UserDetailsService userDetailsService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      log.info("UserDetailsServiceImpl loadUserByUsername()");
        SecurityUserDetails details = null;
        final User user = userService.getUserByName(username);
        final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
        if (user == null && userDetails == null) {
            throw new UsernameNotFoundException("User Not Found In DB And InMemo");
        }

        if (user != null) {
            log.debug(username + " User: Found in DB " + user);
            final SecurityUserDetails securityUserDetails = new SecurityUserDetails(user);
            detailsChecker.check(securityUserDetails);
            details = securityUserDetails;
        }
        if (userDetails != null) {
            log.debug(username + " User: Found in InMemo " + userDetails);
            final SecurityUserDetails securityUserDetails = new SecurityUserDetails(userDetails);
            detailsChecker.check(securityUserDetails);
            details = securityUserDetails;
        }
        return details;
    }
}
