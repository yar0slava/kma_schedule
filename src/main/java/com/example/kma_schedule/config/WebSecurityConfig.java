package com.example.kma_schedule.config;


import com.example.kma_schedule.service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
@EnableGlobalMethodSecurity(jsr250Enabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final ObjectMapper objectMapper;
    private final JwtTokenGenerator jwtTokenGenerator;
    //    private JwtTokenGenerator jwtTokenGenerator;
    private UserServiceImpl userService;

    public WebSecurityConfig(ObjectMapper objectMapper, JwtTokenGenerator jwtTokenGenerator) {
        this.objectMapper = objectMapper;
        this.jwtTokenGenerator = jwtTokenGenerator;
    }

//    public WebSecurityConfig(ObjectMapper objectMapper) {
//        this.objectMapper = objectMapper;
//    }
//
//    @Autowired
//    public void setJwtTokenGenerator(JwtTokenGenerator jwtTokenGenerator) {
//        this.jwtTokenGenerator = jwtTokenGenerator;
//    }

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        http
                .headers().frameOptions().disable().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/sign-up").not().fullyAuthenticated()
                .antMatchers("/sign-in").not().fullyAuthenticated()
                .antMatchers("/records").authenticated()
                .antMatchers("/lectors","/group", "/classtime", "/classroom", "/disciplines").hasAuthority("ADMIN")
                .antMatchers("/css/**").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().permitAll()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(logoutFilter())
                .addFilterBefore(customLoginFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new AuthenticationFilter(userDetailsService(), jwtTokenGenerator), CustomLoginFilter.class);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
        authManagerBuilder
//                .authenticationProvider(activeDirectoryLdapAuthenticationProvider())
                .userDetailsService(userDetailsService());

        authManagerBuilder
//                .authenticationProvider(databaseAuthenticationProvider())
                .userDetailsService(userDetailsService());
    }
//
//    @Bean
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

    @Bean(name= "pwdEncoder")
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    private CustomLoginFilter customLoginFilter() {
        final CustomLoginFilter customLoginFilter =  new CustomLoginFilter(authenticationManagerBean(), objectMapper, jwtTokenGenerator);
        customLoginFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/sign-in", POST.name()));
        return customLoginFilter;
    }

    private LogoutFilter logoutFilter() {
        final LogoutHandler[] logoutHandlers = new LogoutHandler[] {
                new SecurityContextLogoutHandler()
        };

        return new LogoutFilter(new LogoutSuccessHandlerAdapter(), logoutHandlers);
    }
}
