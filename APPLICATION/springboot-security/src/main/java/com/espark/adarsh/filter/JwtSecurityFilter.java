package com.espark.adarsh.filter;

import com.espark.adarsh.util.JwtUtilService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class JwtSecurityFilter extends OncePerRequestFilter {

    @Autowired
    JwtUtilService jwtUtilService;

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        log.info("label=doFilterInternal() security filter execution start ");
        final String authorizationToken = httpServletRequest.getHeader("X-TOKEN");
        if (!StringUtils.isEmpty(authorizationToken)) {
            String userName = this.jwtUtilService.extractUsername(authorizationToken);
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
            if (!StringUtils.isEmpty(userName) && this.jwtUtilService.validateToken(authorizationToken, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                        = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource()
                                .buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        SecurityContextHolder.getContext().setAuthentication(null);
        log.info("label=doFilterInternal() security filter execution end ");
    }
}
