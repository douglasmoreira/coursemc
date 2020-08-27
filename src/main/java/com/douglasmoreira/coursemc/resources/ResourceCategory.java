package com.douglasmoreira.coursemc.resources;

import com.douglasmoreira.coursemc.domain.Category;
import com.douglasmoreira.coursemc.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class ResourceCategory {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Integer id) {

        return ResponseEntity.ok().body(categoryService.findById(id));
    }
}
