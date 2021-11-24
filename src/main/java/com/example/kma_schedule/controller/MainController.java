package com.example.kma_schedule.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class MainController {
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String getAll(){
        return "records";
    }
}
