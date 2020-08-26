package com.douglasmoreira.coursemc.resources;

import com.douglasmoreira.coursemc.domain.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class ResourceCategory {

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> list() {
        Category cat1 = new Category(1, "computing");
        Category cat2 = new Category(1, "office");
        List<Category> list = new ArrayList<>();
        list.add(cat1);
        list.add(cat2);
        return list;
    }
}
