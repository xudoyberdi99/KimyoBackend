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
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public ApiResponse addCategory(CategoryDto categoryDto) {
        Category category=new Category();
        category.setNameEN(categoryDto.getNameEN());
        category.setNameRU(categoryDto.getNameRU());
        category.setNameKR(categoryDto.getNameKR());
        category.setNameUZ(categoryDto.getNameUZ());

        Optional<Category> categoryOptional = categoryRepository.findById(categoryDto.getParentId());
        if (!categoryOptional.isPresent()){
            category.setParent(null);
        }else {
            category.setParent(categoryOptional.get());
        }
        categoryRepository.save(category);
        return new ApiResponse("add category success", true);
    }

    @Override
    public ApiResponse categoryEdit(Long id, CategoryDto categoryDto) {
        Optional<Category> categoryOptionals = categoryRepository.findById(id);
        if (!categoryOptionals.isPresent()){
            return new ApiResponse("not found category", false);
        }
        Category category = categoryOptionals.get();
        category.setNameEN(categoryDto.getNameEN());
        category.setNameRU(categoryDto.getNameRU());
        category.setNameKR(categoryDto.getNameKR());
        category.setNameUZ(categoryDto.getNameUZ());

        Optional<Category> categoryOptional = categoryRepository.findById(categoryDto.getParentId());
        if (!categoryOptional.isPresent()){
            category.setParent(null);
        }else {
            category.setParent(categoryOptional.get());
        }
        categoryRepository.save(category);
        return new ApiResponse("edit category success", true);
    }

    @Override
    public ApiResponse categoryDelete(Long id) {
        try{
            categoryRepository.deleteById(id);
            return new ApiResponse("delete category",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }

    @Override
    public Category categoryGetById(Long id) {
        return categoryRepository.findById(id).orElse(new Category());
    }

    @Override
    public List<Category> allCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> allParentcategory() {
        return categoryRepository.parentCategorys();
    }

    @Override
    public List<Category> allchildcategory(Long parentid) {
        return categoryRepository.findAllByParent_Id(parentid);
    }
}
