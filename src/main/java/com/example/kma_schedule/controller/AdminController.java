package com.example.kma_schedule.controller;

import com.example.kma_schedule.dto.ClassroomDto;
import com.example.kma_schedule.service.ClassroomServiceImpl;
import org.apache.logging.log4j.*;
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
        ThreadContext.put("classroom.name", classroomDto.getName());
        ThreadContext.put("classroom.capacity", classroomDto.getCapacity().toString());
        logger.info(marker, "{} created a new classroom in scheduler with name {} and capacity {}", ThreadContext.get("admin.login"), ThreadContext.get("classroom.name"), ThreadContext.get("classroom.capacity"));
        logger.info(marker, "test 123");
        ThreadContext.clearAll();
    }


}
