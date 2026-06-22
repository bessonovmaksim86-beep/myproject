package com.example.myproject.dto;

import com.example.myproject.domain.enums.CategoryType;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CategoryDto {
    @NotBlank
    private String name;

    @NotNull
    private CategoryType type;
}