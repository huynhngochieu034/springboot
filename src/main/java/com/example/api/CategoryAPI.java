package com.example.api;

import com.example.dto.CategoryDTO;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/api/categorys" })
public class CategoryAPI {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping(produces = "application/json")
    public List<CategoryDTO> getCategorys() {
        return categoryService.findAll();
    }
}
