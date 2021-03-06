package com.douglasmoreira.coursemc.resources;

import com.douglasmoreira.coursemc.CourseMCApplication;
import com.douglasmoreira.coursemc.domain.Category;
import com.douglasmoreira.coursemc.domain.Product;
import com.douglasmoreira.coursemc.services.CategoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = CourseMCApplication.class)
@AutoConfigureMockMvc
public class ResourceCategoryTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CategoryService categoryService;

    private ObjectMapper objectMapper = new ObjectMapper();

    Category category;
    Integer id = 1;
    String json;

    @BeforeEach
    public void setUp() throws JsonProcessingException {
        category = new Category(id, "Office");
        Product product = new Product(id, "printer", 800.0);
        category.getProducts().addAll(asList(product));
        product.getCategories().addAll(asList(category));

        json = objectMapper.writeValueAsString(category);
    }


    @Test
    public void shouldReturnListOfCategory() throws Exception {
        when(categoryService.findById(id)).thenReturn(category);
        this.mockMvc.perform(get("http://localhost:8080/category/{id}", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(json))
                .andReturn();
    }
}
