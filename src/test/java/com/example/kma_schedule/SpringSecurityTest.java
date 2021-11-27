package com.example.kma_schedule;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringSecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser() // TODO add user credentials
    public void signInTest() {
        // TODO
    }
}
