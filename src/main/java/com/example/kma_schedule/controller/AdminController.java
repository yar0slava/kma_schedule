package com.example.kma_schedule.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {


    @GetMapping
    public String getAdminPage() {
        return "testing endpoint for admin only";
    }
}
