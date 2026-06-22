package com.example.myproject.repository;

import com.example.myproject.domain.Category;
import com.example.myproject.domain.enums.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByType(CategoryType type);
}