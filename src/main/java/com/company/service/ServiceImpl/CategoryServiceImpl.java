package com.company.service.ServiceImpl;

import com.company.entity.Category;
import com.company.entity.Conferences;
import com.company.payload.ApiResponse;
import com.company.payload.CategoryDto;
import com.company.repository.CategoryRepository;
import com.company.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public ApiResponse addCategory(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public ApiResponse categoryEdit(Long id, CategoryDto categoryDto) {
        return null;
    }

    @Override
    public ApiResponse categoryDelete(Long id) {
        return null;
    }

    @Override
    public Category categoryGetById(Long id) {
        return null;
    }

    @Override
    public List<Conferences> allCategory() {
        return null;
    }
}
