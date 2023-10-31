package com.carproject.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController("/product")
public class CarController {

    @GetMapping
    public ResponseEntity getAllProducts(){
        List<String> produtos = new ArrayList<>();
        produtos.add("Porsche 911 GTI");
        produtos.add("McLaren Senna");
        return ResponseEntity.ok(produtos);
    }

    @PostMapping
    public ResponseEntity postProduct(@RequestBody String nome){
        return ResponseEntity.ok(nome);
    }



    @GetMapping("/{id}")
    public ResponseEntity getOnlyProduct(@PathVariable Long id){
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity putOnlyProduct(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id){
        return ResponseEntity.ok().build();
    }
}
