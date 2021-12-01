package com.example.kma_schedule;

//@EnableAutoConfiguration(exclude = {WebSecurityConfig.class})
//@WebMvcTest(UserController.class)
//public class SpringWebTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private UserServiceImpl userService;
//
//    @MockBean
//    private JwtTokenGenerator jwtTokenGenerator;
//
//    @SneakyThrows
//    @Test
//    @WithAnonymousUser
//    public void givenSignInURI_whenMockMVC_thenStatusIsOk() {
//        mockMvc
//                .perform(MockMvcRequestBuilders.get("/sign-in"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//}

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringWebTest {

    @Autowired
    private MockMvc mockMvc;

    @SneakyThrows
    @Test
    public void givenSignInURI_whenMockMVC_thenStatusIsOk() {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/sign-in"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}

