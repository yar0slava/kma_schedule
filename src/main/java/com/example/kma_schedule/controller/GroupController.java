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
import java.util.List;

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
    public void createNewGroup(@Valid @RequestBody GroupDto groupDto) {
        groupService.addNewGroup(groupDto);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<GroupDto> getAll(){
        return groupService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GroupDto get(@PathVariable String id){
        return  groupService.getById(id).get();
    }

    @GetMapping("/degree")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<GroupDto> getByDegree(@RequestParam String degree){
        return  groupService.findByDegree(degree);
    }

    @GetMapping("/specialization")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<GroupDto> getBySpecialization(@RequestParam String specialization){
        return  groupService.findBySpecialization(specialization);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id){
        groupService.deleteById(id);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GroupDto update(@RequestBody GroupDto groupDto){
        return groupService.update(groupDto).get();
    }
}
