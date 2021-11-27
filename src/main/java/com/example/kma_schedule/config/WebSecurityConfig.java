package com.example.kma_schedule.config;
//
//
//import com.example.kma_schedule.service.UserServiceImpl;
//import com.example.kma_schedule.service.UserServiceImpl;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.RequiredArgsConstructor;
//import lombok.SneakyThrows;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.authentication.logout.LogoutFilter;
//import org.springframework.security.web.authentication.logout.LogoutHandler;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import static org.springframework.http.HttpMethod.POST;
//
////@RequiredArgsConstructor
////@Configuration
////@EnableGlobalMethodSecurity(jsr250Enabled = true, prePostEnabled = true)
////public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
////
////
////    private final ObjectMapper objectMapper;
////    private final JwtTokenGenerator jwtTokenGenerator;
////
////    @Autowired
////    private UserServiceImpl userService;
////    @Bean
////    public BCryptPasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
////    @Override
////    protected void configure(final HttpSecurity http) throws Exception {
////        http
////                .headers().frameOptions().disable().and()
////                .csrf().disable()
////                .authorizeRequests()
////                .antMatchers("/sign-up").not().fullyAuthenticated()
////                .antMatchers("/records").hasAnyRole("USER","ADMIN")
////                .antMatchers("/lectors","/group", "/classtime", "/classroom", "/disciplines").hasRole("ADMIN")
////                .antMatchers("/css/**").permitAll()
////                .antMatchers("/h2-console/**").permitAll()
////                .and()
////                .formLogin()
////                .loginPage("/sign-in")
////                .permitAll();
////
//////
//////        http
//////                .csrf().disable()
//////                .authorizeRequests()
//////                .antMatchers("/sign-up").not().fullyAuthenticated()
//////                .antMatchers("/lectors", "/group", "/classtime", "/classroom", "/disciplines").hasRole("ADMIN")
//////                .antMatchers("/records").permitAll()
//////
//////                .antMatchers("/css/**").permitAll()
//////                .anyRequest().permitAll()
//////                .and()
//////                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//////                .and()
//////                .addFilter(logoutFilter())
//////                .addFilterBefore(customLoginFilter(), UsernamePasswordAuthenticationFilter.class)
//////                .addFilterBefore(new AuthenticationFilter(userDetailsService(), jwtTokenGenerator), CustomLoginFilter.class);
////
////    }
////
//////    @Override
//////    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
//////        authManagerBuilder
////////                .authenticationProvider(activeDirectoryLdapAuthenticationProvider())
//////                .userDetailsService(userDetailsService());
//////
//////        authManagerBuilder
////////                .authenticationProvider(databaseAuthenticationProvider())
//////                .userDetailsService(userDetailsService());
//////    }
////
////    @Autowired
////    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
////    }
////
//////    @Bean
//////    @SneakyThrows
//////    @Override
//////    public AuthenticationManager authenticationManagerBean() {
//////        return super.authenticationManagerBean();
//////    }
//////
//////
//////    private CustomLoginFilter customLoginFilter() {
//////        final CustomLoginFilter customLoginFilter =  new CustomLoginFilter(authenticationManagerBean(), objectMapper, jwtTokenGenerator);
//////        customLoginFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login", POST.name()));
//////
//////        return customLoginFilter;
//////    }
//////
//////    private LogoutFilter logoutFilter() {
//////        final LogoutHandler[] logoutHandlers = new LogoutHandler[] {
//////                new SecurityContextLogoutHandler()
//////        };
//////
//////        return new LogoutFilter(new LogoutSuccessHandlerAdapter(), logoutHandlers);
//////    }
////}
//
//
//import static org.springframework.http.HttpMethod.POST;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.logout.LogoutFilter;
//import org.springframework.security.web.authentication.logout.LogoutHandler;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import lombok.RequiredArgsConstructor;
//import lombok.SneakyThrows;
//
//@RequiredArgsConstructor
//@Configuration
//@EnableGlobalMethodSecurity(jsr250Enabled = true, prePostEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
////    private final UserServiceImpl userService;
//    private final ObjectMapper objectMapper;
//    private final JwtTokenGenerator jwtTokenGenerator;
//
//    //        http
////                .headers().frameOptions().disable().and()
////                .csrf().disable()
////                .authorizeRequests()
////                .antMatchers("/sign-up").not().fullyAuthenticated()
////                .antMatchers("/records").hasAnyRole("USER","ADMIN")
////                .antMatchers("/lectors","/group", "/classtime", "/classroom", "/disciplines").hasRole("ADMIN")
////                .antMatchers("/css/**").permitAll()
////                .antMatchers("/h2-console/**").permitAll()
////                .and()
////                .formLogin()
////                .loginPage("/sign-in")
////                .permitAll();
//
//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
//        http
//                .headers().frameOptions().disable().and()
//               .csrf().disable()
//                .authorizeRequests()
////                .antMatchers(HttpMethod.GET, "/profile").authenticated()
////                .antMatchers(HttpMethod.GET, "/reception/**").authenticated()
//                .anyRequest().permitAll()
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .addFilter(logoutFilter())
//               .addFilterBefore(customLoginFilter(), UsernamePasswordAuthenticationFilter.class);
//                //.addFilterBefore(new AuthenticationFilter(userDetailsService(), jwtTokenGenerator), CustomLoginFilter.class);
////    http
////            .headers().frameOptions().disable().and()
////            .csrf().disable()
////                .authorizeRequests()
////                .antMatchers("/sign-up").not().fullyAuthenticated()
////                .antMatchers("/records").hasAnyRole("USER","ADMIN")
////                .antMatchers("/lectors","/group", "/classtime", "/classroom", "/disciplines").hasRole("ADMIN")
////                .antMatchers("/css/**").permitAll()
////                .antMatchers("/h2-console/**").permitAll()
////                .and()
////                .formLogin()
////                .loginPage("/sign-in")
////                .permitAll()
////                .and()
////                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////                .and()
////                .addFilter(logoutFilter());
//               //.addFilterBefore(customLoginFilter(), UsernamePasswordAuthenticationFilter.class);
//               // .addFilterBefore(new AuthenticationFilter(userDetailsService(), jwtTokenGenerator), CustomLoginFilter.class);
//
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
//        authManagerBuilder
////                .authenticationProvider(activeDirectoryLdapAuthenticationProvider())
//                .userDetailsService(userDetailsService());
//
//        authManagerBuilder
////                .authenticationProvider(databaseAuthenticationProvider())
//                .userDetailsService(userDetailsService());
//    }
//
////    @Bean
////    @Override
////    protected UserDetailsService userDetailsService() {
////        return userService;
////    }
//
//    @Bean
//    @SneakyThrows
//    @Override
//    public AuthenticationManager authenticationManagerBean() {
//        return super.authenticationManagerBean();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    private CustomLoginFilter customLoginFilter() {
//        final CustomLoginFilter customLoginFilter =  new CustomLoginFilter(authenticationManagerBean(), objectMapper, jwtTokenGenerator);
//        customLoginFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login", POST.name()));
//
//        return customLoginFilter;
//    }
//
//    private LogoutFilter logoutFilter() {
//        final LogoutHandler[] logoutHandlers = new LogoutHandler[] {
//                new SecurityContextLogoutHandler()
//        };
//
//        return new LogoutFilter(new LogoutSuccessHandlerAdapter(), logoutHandlers);
//    }
//}


import static org.springframework.http.HttpMethod.POST;


import com.example.kma_schedule.config.AuthenticationFilter;
import com.example.kma_schedule.config.CustomLoginFilter;
import com.example.kma_schedule.config.JwtTokenGenerator;
import com.example.kma_schedule.config.LogoutSuccessHandlerAdapter;
import com.example.kma_schedule.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
@Configuration
@EnableGlobalMethodSecurity(jsr250Enabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final ObjectMapper objectMapper;
    private final JwtTokenGenerator jwtTokenGenerator;
//    private final UserServiceImpl userService;
//
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().disable().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/sign-up").not().fullyAuthenticated()
//                .antMatchers("/records").hasAnyRole("USER", "ADMIN")
                .anyRequest().permitAll()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                .and()
//                .addFilter(logoutFilter())
//                .addFilterBefore(customLoginFilter(), UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(new AuthenticationFilter(userDetailsService(), jwtTokenGenerator), CustomLoginFilter.class);

    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
//        authManagerBuilder
////                .authenticationProvider(activeDirectoryLdapAuthenticationProvider())
//                .userDetailsService(userDetailsService());
//
//        authManagerBuilder
////                .authenticationProvider(databaseAuthenticationProvider())
//                .userDetailsService(userDetailsService());
//    }
////
//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        return userService;
//    }
//
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
//
//    private CustomLoginFilter customLoginFilter() {
//        final CustomLoginFilter customLoginFilter =  new CustomLoginFilter(authenticationManagerBean(), objectMapper, jwtTokenGenerator);
//        customLoginFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/sign-in", POST.name()));
//        return customLoginFilter;
//    }

    private LogoutFilter logoutFilter() {
        final LogoutHandler[] logoutHandlers = new LogoutHandler[] {
                new SecurityContextLogoutHandler()
        };

        return new LogoutFilter(new LogoutSuccessHandlerAdapter(), logoutHandlers);
    }
}
