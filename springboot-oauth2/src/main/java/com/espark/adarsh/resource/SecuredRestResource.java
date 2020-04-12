package com.espark.adarsh.resource;

import com.espark.adarsh.bean.UserProfile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecuredRestResource {

    @GetMapping("/api/users/me")
    public ResponseEntity<UserProfile> profile() {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if ((object instanceof User)) {
            User user = (User) object;
            String email = user.getUsername() + "@espark.com";
            UserProfile profile = new UserProfile();
            profile.setName(user.getUsername());
            profile.setEmail(email);
            return ResponseEntity.ok(profile);
        } else {
            return ResponseEntity.ok(new UserProfile("annonimus","annonimus@unknown.com"));
        }
    }


}
