package com.douglasmoreira.coursemc.services;

import com.douglasmoreira.coursemc.domain.Category;
import com.douglasmoreira.coursemc.repositories.CategoryRepository;
import com.douglasmoreira.coursemc.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CategoryServiceTest {

    @MockBean
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    @Test
    public void shouldGetCategoryById() {
        Integer id = 1;
        String name = "Computing";

        when(categoryRepository.findById(any())).thenReturn(java.util.Optional.of(new Category(id, name)));

        Category result = categoryService.findById(id);

        assertNotNull(result);
        assertTrue(result.getId().equals(id));
        assertTrue(result.getName().equals(name));
    }

    @Test
    public void shouldThrowObjectNotFoundException() {
        Integer id = 1;

        try {
            categoryService.findById(id);
        } catch (ObjectNotFoundException e) {
            assertEquals("object not found id: " + id +
                    ", Type: " + Category.class.getName(), e.getMessage());
        }

    }
}
