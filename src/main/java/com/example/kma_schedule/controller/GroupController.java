package com.example.kma_schedule.controller;

import com.example.kma_schedule.dto.GroupDto;
import com.example.kma_schedule.service.GroupService;
import com.example.kma_schedule.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private LecturerService lecturerService;

    @GetMapping()
    public String getGroupPage(Model model) {
        System.out.println(lecturerService.getAll());
        model.addAttribute("lectors", lecturerService.getAll());
        return "add-group";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewDiscipline(@Valid @RequestBody GroupDto groupDto) {
        groupService.addNewGroup(groupDto);
    }
}
