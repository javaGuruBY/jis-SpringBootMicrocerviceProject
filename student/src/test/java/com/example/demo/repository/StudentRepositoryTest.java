package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class StudentRepositoryTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void test() throws Exception {

        String result = mockMvc.perform(MockMvcRequestBuilders.get("/students"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getRequest().getContentAsString();

    }
}
