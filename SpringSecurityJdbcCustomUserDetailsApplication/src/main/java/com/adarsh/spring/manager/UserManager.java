package com.adarsh.spring.manager;

import com.adarsh.spring.entity.User;
import com.adarsh.spring.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Service
public class UserManager {

    @Value("${user.query}")
    private String userFetchQuery;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUser(Long id) {
        User user = new User();

        return user;
    }

    public User getUser(String userName) {
        final User user = new User();
        final UserRole userRole = new UserRole();
        final Map<String, Object> map = jdbcTemplate.queryForMap(userFetchQuery, new Object[]{userName});
        userRole.setId((Long) map.get("USER_ROLE_ID"));
        userRole.setName(map.get("AUTHORITY").toString());
        userRole.setUserId((Long) map.get("USER_ID"));

        user.setUserId((Long) map.get("USER_ID"));
        user.setUserName(map.get("USERNAME").toString());
        user.setUserPwd(map.get("PASSWORD").toString());
        user.setEnable(Boolean.parseBoolean(map.get("ENABLED").toString()));

        user.setUserRole(userRole);
        return user;
    }
}
