package com.example.kma_schedule.controller;


import com.example.kma_schedule.database.entity.User;
import com.example.kma_schedule.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.Arrays;
import java.util.List;

@Controller
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
    public String postSignIn(@ModelAttribute User user, Model model) {
        List<String> errors = userService.login(user.getUsername(),user.getPassword());
//        for(int i=0; i< errors.size(); i++){
//            System.out.println(errors.get(i));
//        }
        System.out.println("ERRORSSSSSS");
        System.out.println(Arrays.toString(errors.toArray()));

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