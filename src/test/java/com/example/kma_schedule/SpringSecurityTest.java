package com.example.kma_schedule;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringSecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @SneakyThrows
    @Test
    @WithAnonymousUser
    public void signInTest() {
        mockMvc.perform(MockMvcRequestBuilders.get("/records"))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }
}
