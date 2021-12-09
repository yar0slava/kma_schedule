package com.example.kma_schedule;

import com.example.kma_schedule.config.JwtTokenGenerator;
import com.example.kma_schedule.controller.LecturerController;
import com.example.kma_schedule.database.repository.*;
import com.example.kma_schedule.service.LecturerServiceImpl;
import com.example.kma_schedule.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LecturerController.class)
public class SpringMVCTest {

    @MockBean
    private UserServiceImpl userService;

    @MockBean
    private JwtTokenGenerator jwtTokenGenerator;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private LecturerServiceImpl lecturerService;

    @MockBean
    private RecordRepository recordRepository;

    @MockBean
    private ClassTimeRepository classTimeRepository;

    @MockBean
    private GroupRepository groupRepository;

    @MockBean
    private LecturerRepository lecturerRepository;

    @MockBean
    private RoleRepository roleRepository;

    @MockBean
    private AdminRepository adminRepository;

    @MockBean
    private ClassroomRepository classroomRepository;

    @MockBean
    private DisciplineRepository disciplineRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenInvalidPath_thenReturnStatus404() throws Exception {
        mockMvc.perform(get("/s43s36s643s"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void whenDeleteWithBadId_thenReturnStatus400() throws Exception {
        mockMvc.perform(delete("/lectors/rgerg")
                        .contentType("application/json"))
                .andExpect(status().isBadRequest());
    }
}

