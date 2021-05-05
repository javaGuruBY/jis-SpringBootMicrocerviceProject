package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.example.demo.bean.StudentService;
import com.example.demo.common.AbstractTest;
import com.example.demo.model.TutritHomeDto;
import com.example.demo.proxy.TutritProxy;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HomeConrollerTest extends AbstractTest {

    @MockBean
    StudentService studentService;
    @MockBean
    TutritProxy tutritProxy;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @Transactional
    @Sql("/getHomeTestData.sql")
    void getHome() throws Exception {
        Mockito.when(studentService.getBestStudent()).thenReturn(new Student(10L, "Maksim Shelkovich10"));

        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(getExpected()));
//        mockMvc.perform(MockMvcRequestBuilders.get("/"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andReturn().getResponse().getContentAsString().equals("hello");
    }

    @Test
    public void testTutrit() throws Exception {
        Mockito.when(tutritProxy.getHome()).thenReturn(new TutritHomeDto("DB updated"));

        String result = mockMvc.perform(MockMvcRequestBuilders.get("/tutrit"))
                .andDo(print())
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        TutritHomeDto actualTutrit = objectMapper.readValue(result, TutritHomeDto.class);
        assertEquals(getExpectedTutritDto(), actualTutrit);
    }

    private String getExpected() throws JsonProcessingException {
        return objectMapper.writeValueAsString(new Student(10L, "Maksim Shelkovich10"));
    }

    private TutritHomeDto getExpectedTutritDto() {
        return new TutritHomeDto("DB updated");
    }
}
