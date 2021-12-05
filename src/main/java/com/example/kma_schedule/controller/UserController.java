package com.example.kma_schedule.controller;

import com.example.kma_schedule.database.entity.User;
import com.example.kma_schedule.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
//
//    @GetMapping("/sign-in")
//    public String getSignIn(Model model) {
//        model.addAttribute("user", new User());
//        model.addAttribute("error", null);
//        return "login";
//    }
//
//    @GetMapping("/sign-up")
//    public String getSignUp(Model model) {
//        model.addAttribute("user", new User());
//        return "signup";
//    }


    //for 9 lab
    @PostMapping("/sign-up")
    @ResponseBody
    public String postSignUp(@ModelAttribute User user, Model model) {
        System.out.println("here sign up");
        List<String> errors = userService.signup(user);
        if (errors.isEmpty()) {
            return "redirect:/sign-in";
        }

        model.addAttribute("error", errors.get(0));
        return "signup";
    }

    //for react
//    @PostMapping("/sign-up")
//    @ResponseBody
//    public String postSignUp(@RequestBody User user, Model model) {
//        System.out.println("here sign up");
//        List<String> errors = userService.signup(user);
//        if (errors.isEmpty()) {
//            return "redirect:/sign-in";
//        }
//
//        model.addAttribute("error", errors.get(0));
//        return "signup";
//    }
}