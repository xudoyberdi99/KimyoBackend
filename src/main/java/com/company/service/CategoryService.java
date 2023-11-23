package com.company.service;

import com.company.entity.Category;
import com.company.entity.Conferences;
import com.company.payload.ApiResponse;
import com.company.payload.CategoryDto;

import java.util.List;

public interface CategoryService {
    ApiResponse addCategory(CategoryDto categoryDto);

    ApiResponse categoryEdit(Long id, CategoryDto categoryDto);

    ApiResponse categoryDelete(Long id);

    Category categoryGetById(Long id);

    List<Conferences> allCategory();
}
