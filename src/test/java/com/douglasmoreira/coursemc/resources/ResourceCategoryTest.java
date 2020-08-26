package com.douglasmoreira.coursemc.resources;

import com.douglasmoreira.coursemc.CourseMCApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = CourseMCApplication.class)
@AutoConfigureMockMvc
public class ResourceCategoryTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnListOfCategory() throws Exception {
        this.mockMvc.perform(get("http://localhost:8080/category")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
}
