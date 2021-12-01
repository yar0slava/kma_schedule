package com.example.kma_schedule.config;

import com.example.kma_schedule.database.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class CustomLoginFilter extends UsernamePasswordAuthenticationFilter {
    private final ObjectMapper objectMapper;
    private final JwtTokenGenerator jwtTokenGenerator;

    CustomLoginFilter(
            final AuthenticationManager authenticationManager,
            final ObjectMapper objectMapper,
            final JwtTokenGenerator jwtTokenGenerator
    ) {
        this.objectMapper = objectMapper;
        this.jwtTokenGenerator = jwtTokenGenerator;
        setAuthenticationManager(authenticationManager);
    }

    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(final HttpServletRequest request, final HttpServletResponse response) {
        final UserCredentials userCredentials = objectMapper.readValue(request.getInputStream(), UserCredentials.class);
        System.out.println("USER CREDS " + userCredentials.getEmail() + " " + userCredentials.getPassword());

        final UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(userCredentials.getEmail(), userCredentials.getPassword(), new ArrayList<>());

        System.out.println(userCredentials.getPassword());

        return getAuthenticationManager().authenticate(authToken);
    }

    @SneakyThrows
    @Override
    protected void successfulAuthentication(final HttpServletRequest request, final HttpServletResponse response,
                                            final FilterChain chain, final Authentication auth) {

        SecurityContextHolder.getContext().setAuthentication(auth);
        final User authenticatedUser = (User) auth.getPrincipal();

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        response.getWriter().write("{}");
        response.setHeader(HttpHeaders.SET_COOKIE, "token="+jwtTokenGenerator.generateToken(authenticatedUser));
        System.out.println("SUCCESS");
    }

    @SneakyThrows
    @Override
    protected void unsuccessfulAuthentication(
            final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException failed
    ) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        System.out.println("ERROR");
    }

    @Value
    private static class UserCredentials {
        private final String email;
        private final String password;
    }
}
