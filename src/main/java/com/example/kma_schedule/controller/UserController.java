package com.example.kma_schedule.controller;

import com.example.kma_schedule.config.JwtTokenGenerator;
import com.example.kma_schedule.database.entity.User;
import com.example.kma_schedule.dto.LoginRequestDto;
import com.example.kma_schedule.dto.LoginResponseDto;
import com.example.kma_schedule.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenGenerator jwtUtil;
    private final UserServiceImpl userService;

    public UserController(AuthenticationManager authenticationManager, JwtTokenGenerator jwtUtil, UserServiceImpl userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @GetMapping("/sign-in")
    public String getSignIn(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("error", null);
        return "login";
    }

    @GetMapping("/sign-up")
    public String getSignUp(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @ResponseBody
    @PostMapping(value = "/sign-in")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) throws  Exception{
        authenticate(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        final UserDetails userDetails = userService.loadUserByUsername(loginRequestDto.getEmail());
        final String token = jwtUtil.generateToken(userDetails);
        return new LoginResponseDto(token);
    }

    @PostMapping("/sign-up")
    public String postSignUp(@ModelAttribute User user, Model model) {
        List<String> errors = userService.signup(user);
        if (errors.isEmpty()) {
            return "redirect:/sign-in";
        }
        model.addAttribute("error", errors.get(0));
        return "signup";
    }

    private void authenticate(String username, String password) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (DisabledException e){
            throw new Exception("USER_DISABLED", e);
        }catch (BadCredentialsException e){
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}