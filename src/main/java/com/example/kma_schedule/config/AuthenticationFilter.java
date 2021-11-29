package com.example.kma_schedule.config;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class AuthenticationFilter extends OncePerRequestFilter {

    private final UserDetailsService userDetailsService;
    private final JwtTokenGenerator jwtTokenGenerator;

    @Override
    protected void doFilterInternal(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse, final FilterChain filterChain)
            throws ServletException, IOException {

//        final String token = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        Cookie cookie = WebUtils.getCookie(httpServletRequest, "token");
        final String token = cookie != null ? cookie.getValue() : "";
        if (!StringUtils.hasText(token)) {
            System.out.println("anonymous request to endpoint " + httpServletRequest.getMethod() + " " + getRequestPath(httpServletRequest));
            filterChain.doFilter(httpServletRequest, httpServletResponse);      // <--- important
            return;
        }

        final String username = jwtTokenGenerator.getUsernameFromToken(token);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
        System.out.println("user " + username + " send request to endpoint " + httpServletRequest.getMethod() + " " + getRequestPath(httpServletRequest));
        filterChain.doFilter(httpServletRequest, httpServletResponse);          // <--- important
    }

    private static String getRequestPath(final HttpServletRequest request) {
        return request.getRequestURI() + "?" + request.getQueryString();
    }
}
