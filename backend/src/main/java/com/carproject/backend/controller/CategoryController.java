package com.carproject.backend.controller;

import com.carproject.backend.model.Category;
import com.carproject.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity getAllCategories(){
        List<Category> categories = categoryService.getAll();

        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity postCategory(@RequestBody Category category){

        categoryService.post(category);
        return ResponseEntity.ok(category);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCategory(@PathVariable Long id){
        return categoryService.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity putCategory(@PathVariable Long id, @RequestBody Category category){
        Category newCategory = categoryService.updateCategory(id, category);
        return ResponseEntity.ok(newCategory);
    }
}
