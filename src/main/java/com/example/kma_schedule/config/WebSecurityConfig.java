package com.example.kma_schedule.config;

import com.example.kma_schedule.service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(jsr250Enabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserServiceImpl userService;
    private final ObjectMapper objectMapper;
    private final JwtTokenGenerator jwtTokenGenerator;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return userService;
    }

    @Bean
    @SneakyThrows
    @Override
    public AuthenticationManager authenticationManagerBean() {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService());
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().permitAll()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(customLoginFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilter(logoutFilter())
                .addFilterBefore(new AuthenticationFilter(userDetailsService(), jwtTokenGenerator), CustomLoginFilter.class);

    }

    private CustomLoginFilter customLoginFilter() {
        final CustomLoginFilter customLoginFilter = new CustomLoginFilter(authenticationManagerBean(), objectMapper, jwtTokenGenerator);
        customLoginFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login", POST.name()));

        return customLoginFilter;
    }

    private LogoutFilter logoutFilter() {
        final LogoutHandler[] logoutHandlers = new LogoutHandler[]{
                new SecurityContextLogoutHandler()
        };

        return new LogoutFilter(new LogoutSuccessHandlerAdapter(), logoutHandlers);
    }
}
