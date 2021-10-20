package com.example.kma_schedule.controller;

import com.example.kma_schedule.dto.ClassroomDto;
import com.example.kma_schedule.service.ClassroomServiceImpl;
import org.apache.log4j.MDC;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private static final Logger logger = LogManager.getLogger(AdminController.class);
    private static final Marker marker = MarkerManager.getMarker("ADMIN");
    private final ClassroomServiceImpl classroomService;

    public AdminController(ClassroomServiceImpl classroomService) {
        this.classroomService = classroomService;
    }


    @GetMapping
    public String getAdminPage() {
        return "testing endpoint for admin only";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewClassroom(@RequestBody ClassroomDto classroomDto) {
        classroomService.addNewClassroom(classroomDto);
        MDC.put("admin.login",classroomDto.getAdminLogin());
        MDC.put("classroom.name", classroomDto.getName());
        MDC.put("classroom.capacity", classroomDto.getCapacity());
        logger.info(marker, "{} created a new classroom in scheduler with name {} and capacity {}", MDC.get("admin.login"), MDC.get("classroom.name"), MDC.get("classroom.capacity"));
        MDC.clear();
    }


}
