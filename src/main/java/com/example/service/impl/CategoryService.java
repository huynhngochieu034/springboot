package com.example.service.impl;

import com.example.converter.CategoryConverter;
import com.example.dto.CategoryDTO;
import com.example.entity.CategoryEntity;
import com.example.entity.NewEntity;
import com.example.repository.CategoryRepository;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    public Map<String, String> getCategories() {
        Map<String, String> categories = new HashMap<>();
        List<CategoryEntity> entities = categoryRepository.findAll();
        entities.forEach(item -> {
            categories.put(item.getCode(), item.getName());
        });
        return categories;
    }

    @Override
    public List<CategoryDTO> findAll() {
        List<CategoryEntity> list = categoryRepository.findAll();
        return list.stream().map(item -> categoryConverter.convertToDto(item)).collect(Collectors.toList());
    }
}
