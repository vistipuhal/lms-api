package com.fairwaysoftware.lms.security;

import com.fairwaysoftware.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private TokenHelper tokenHelper;

    @Autowired
    private UserService userService;

    private Integer headerLength = TokenHelper.AUTHORIZATION_HEADER_PREFIX.length() + 1;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (!StringUtils.isEmpty(authorizationHeader) && authorizationHeader.startsWith(TokenHelper.AUTHORIZATION_HEADER_PREFIX)) {
            String token = authorizationHeader.substring(headerLength);
            Integer userId = tokenHelper.parseToken(token);
            userService.findById(userId).ifPresent(user -> {
                List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
                Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, grantedAuthorities);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            });
        }
        chain.doFilter(request, response);
    }

}
