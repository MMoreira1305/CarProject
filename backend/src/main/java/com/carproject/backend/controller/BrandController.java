package com.carproject.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class BrandController {

    @GetMapping
    public ResponseEntity getAllBrands(){
        List<String> brands = new ArrayList<>();
        brands.add("SUV");
        brands.add("Hatch");

        return ResponseEntity.ok(brands);
    }

    @PostMapping
    public ResponseEntity postBrand(@RequestBody String nome){
        return ResponseEntity.ok(nome);
    }

    @GetMapping("/{id}")
    public ResponseEntity getBrand(@PathVariable Long id){
        return ResponseEntity.ok(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity putBrand(@PathVariable Long id){
        return ResponseEntity.ok(id);
    }
}
