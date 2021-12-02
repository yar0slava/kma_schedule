package com.example.kma_schedule;

//@SpringBootTest
//@AutoConfigureMockMvc
//public class SpringWebTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @SneakyThrows
//    @Test
//    public void givenSignInURI_whenMockMVC_thenStatusIsOk() {
//        mockMvc
//                .perform(MockMvcRequestBuilders.get("/sign-in"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//}

import com.example.kma_schedule.config.JwtTokenGenerator;
import com.example.kma_schedule.controller.UserController;
import com.example.kma_schedule.database.repository.*;
import com.example.kma_schedule.service.UserServiceImpl;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(UserController.class)
public class SpringWebTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServiceImpl userService;

    @MockBean
    private JwtTokenGenerator jwtTokenGenerator;

    @MockBean
    private UserRepository userRepository;

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

    @SneakyThrows
    @Test
    public void givenSignInURI_whenMockMVC_thenStatusIsOk() {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/sign-in"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}

