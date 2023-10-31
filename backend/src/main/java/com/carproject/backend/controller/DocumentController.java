package com.carproject.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class DocumentController {
    @GetMapping
    public ResponseEntity getAllDocuments(){
        List<String> documents = new ArrayList<>();
        documents.add("SUV");
        documents.add("Hatch");

        return ResponseEntity.ok(documents);
    }

    @PostMapping
    public ResponseEntity postDocument(@RequestBody String nome){
        return ResponseEntity.ok(nome);
    }

    @GetMapping("/{id}")
    public ResponseEntity getDocument(@PathVariable Long id){
        return ResponseEntity.ok(id);
    }
}
