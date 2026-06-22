package com.abhishek;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StartApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
        // Vérifie que le contexte Spring démarre correctement
    }

    @Test
    void indexPageShouldReturnStatusOk() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    void indexPageShouldContainExpectedTitle() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(content().string(containsString(
                        "I have successfuly built a sprint boot application using Maven")));
    }

    @Test
    void indexPageShouldContainExpectedMessage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(content().string(containsString(
                        "This application is deployed on to Kubernetes using Argo CD")));
    }
}
