package com.example.kma_schedule.controller;


import com.example.kma_schedule.database.entity.User;
import com.example.kma_schedule.dto.LoginDto;
import com.example.kma_schedule.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    private final UserServiceImpl userService;


    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/sign-in")
    public String getSignIn(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("error", null);
        return "login";
    }

    @PostMapping("/sign-in")
    public String postSignIn(@ModelAttribute LoginDto user, Model model) {
        System.out.println("USERRR");
        System.out.println(user.toString());
        List<String> errors = userService.login(user.getUsername(),user.getPassword());
        System.out.println("Errors\n" + Arrays.toString(errors.toArray()));

        if(errors.isEmpty()){
            return "redirect:/records";
        }
        model.addAttribute("err", errors.get(0));
        return "login";
    }

    @GetMapping("/sign-up")
    public String getSignUp(Model model) {
        System.out.println("sign up get");
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/sign-up")
    public String postSignUp(@ModelAttribute User user, Model model) {
        System.out.println("sign up post");
        List<String> errors = userService.signup(user);
        if (errors.isEmpty()) {
            return "redirect:/sign-in";
        }
        model.addAttribute("error", errors.get(0));
        return "signup";
    }

}

//    private final AuthenticationManager authenticationManager;
//    private final JwtTokenGenerator jwtUtil;
//    private final UserDetailsService userDetailsService;
//    private final UserService userService;
//
//    public LoginController(AuthenticationManager authenticationManager, JwtTokenGenerator jwtUtil, UserDetailsService userDetailsService, UserService userService) {
//        this.authenticationManager = authenticationManager;
//        this.jwtUtil = jwtUtil;
//        this.userDetailsService = userDetailsService;
//        this.userService = userService;
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String getSignIn(Model model) {
////        model.addAttribute("user", new User());
//        model.addAttribute("error", null);
//        return "login";
//    }
//    @RequestMapping(value = "/signup", method = RequestMethod.GET)
//    public String getSignUp() {
////        model.addAttribute("user", new User());
//        return "signup";
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.OK)
//    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) throws  Exception{
//        System.out.println(loginRequestDto.getEmail());
//        authenticate(loginRequestDto.getEmail(), loginRequestDto.getPassword());
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequestDto.getEmail());
//        final String token = jwtUtil.generateToken(userDetails);
//        System.out.println("TOKN" + token);
//        return new LoginResponseDto(token);
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/signup", method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    public UserDto signUp(@RequestBody AddUserDto userDto) throws UserService.WrongHospitalCodeException {
//
//        return userService.addUser(userDto);
//    }
//
//    private void authenticate(String username, String password) throws Exception{
//        try{
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        }catch (DisabledException e){
//            throw new Exception("USER_DISABLED", e);
//        }catch (BadCredentialsException e){
//            throw new Exception("INVALID_CREDENTIALS", e);
//        }
//    }