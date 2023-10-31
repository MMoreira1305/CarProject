package com.carproject.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("/category")
public class CategoryController {

    @GetMapping
    public ResponseEntity getAllCategories(){
        List<String> categories = new ArrayList<>();
        categories.add("SUV");
        categories.add("Hatch");

        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity postCategory(@RequestBody String nome){
        return ResponseEntity.ok(nome);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCategory(@PathVariable Long id){
        return ResponseEntity.ok(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity putCategory(@PathVariable Long id){
        return ResponseEntity.ok(id);
    }
}
