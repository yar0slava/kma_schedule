package com.example.kma_schedule.controller;

import lombok.var;
import org.springframework.core.io.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class MainController {

    @GetMapping("/data/book.pdf")
    public void getSteamingFile(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"book.pdf\"");
        var res = new ClassPathResource("data/book.pdf");
        InputStream inputStream = new FileInputStream(res.getFile());
        int nRead;
        while ((nRead = inputStream.read()) != -1) {
            response.getWriter().write(nRead);
        }
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String getMain(){
        return "index";
    }
}
