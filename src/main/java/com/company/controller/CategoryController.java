package com.company.controller;

import com.company.entity.Category;
import com.company.entity.Conferences;
import com.company.payload.ApiResponse;
import com.company.payload.CategoryDto;
import com.company.payload.ConferencesDto;
import com.company.service.CategoryService;
import com.company.service.ConferencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/user/addCategory")
    public ResponseEntity<?> addCategory(@Valid @RequestBody CategoryDto categoryDto){
        ApiResponse apiResponse=categoryService.addCategory(categoryDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @PutMapping("/user/categoryEdit/{id}")
    public HttpEntity<?> categoryEdit(@Valid @PathVariable Long id, @RequestBody CategoryDto categoryDto){
        ApiResponse apiResponse=categoryService.categoryEdit(id,categoryDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @DeleteMapping("/user/categoryDelete/{id}")
    public HttpEntity<?> categoryDelete(@PathVariable Long id){
        ApiResponse apiResponse=categoryService.categoryDelete(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @GetMapping("/public/categoryGetById/{id}")
    public HttpEntity<?> categoryGetById(@PathVariable Long id){
        Category category=categoryService.categoryGetById(id);
        return ResponseEntity.ok(category);
    }

    @GetMapping("/public/allcategory")
    public HttpEntity<?> allcategory(){
        List<Category> getAllCategory=categoryService.allCategory();
        return ResponseEntity.ok(getAllCategory);
    }
    @GetMapping("/public/allParentcategory")
    public HttpEntity<?> allParentcategory(){
        List<Category> getAllCategory=categoryService.allParentcategory();
        return ResponseEntity.ok(getAllCategory);
    }

    @GetMapping("/public/childcategorys/{parentid}")
    public HttpEntity<?> allchildcategory(@PathVariable Long parentid){
        List<Category> getAllCategory=categoryService.allchildcategory(parentid);
        return ResponseEntity.ok(getAllCategory);
    }
}
