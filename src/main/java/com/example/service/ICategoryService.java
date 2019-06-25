package com.example.service;

import com.example.dto.CategoryDTO;
import com.example.dto.NewDTO;

import java.util.List;
import java.util.Map;

public interface ICategoryService {
    Map<String, String> getCategories();
    List<CategoryDTO> findAll();
}
