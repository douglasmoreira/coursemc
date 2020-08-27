package com.douglasmoreira.coursemc.services;

import com.douglasmoreira.coursemc.domain.Category;
import com.douglasmoreira.coursemc.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
