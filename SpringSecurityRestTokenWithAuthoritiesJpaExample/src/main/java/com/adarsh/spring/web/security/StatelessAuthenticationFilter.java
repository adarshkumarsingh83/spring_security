package com.adarsh.spring.web.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 1/1/13 00:11 AM#$
 */
public class StatelessAuthenticationFilter extends GenericFilterBean {

    private static final Logger log = LoggerFactory.getLogger(StatelessAuthenticationFilter.class);
    private TokenAuthenticationService tokenAuthenticationService;
    private static final String AUTH_HEADER_NAME = "X-AUTH-TOKEN";

    protected StatelessAuthenticationFilter(TokenAuthenticationService taService) {
        this.tokenAuthenticationService = taService;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        log.info("StatelessAuthenticationFilter doFilter()");
        /*
          If First Time Auth Header will be Null
          But After Authentication it will be having Auth Token
          which need to translate into the UserDetails Object by using
          tokenAuthenticationService.getAuthentication()
         */
        if (((HttpServletRequest) req).getHeader(AUTH_HEADER_NAME) != null) {
            log.info("StatelessAuthenticationFilter doFilter() Token Found In Request Header");
            SecurityContextHolder.getContext().setAuthentication(
                    tokenAuthenticationService.getAuthentication((HttpServletRequest) req));
        }
        chain.doFilter(req, res);
    }
}