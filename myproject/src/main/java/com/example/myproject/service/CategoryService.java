package com.example.myproject.service;

import com.example.myproject.domain.Category;
import com.example.myproject.dto.CategoryDto;
import java.util.List;

public interface CategoryService {
    Category create(CategoryDto dto);
    List<Category> findAll();
    Category findById(Long id);
    void delete(Long id);
}