package com.carproject.controller;

import com.carproject.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @GetMapping
    public ResponseEntity getAllDocuments(){
        return ResponseEntity.ok(documentService.getAll());
    }

    @Secured(value = "admin")
    @PostMapping
    public ResponseEntity postDocument(@RequestBody String nome){
        return ResponseEntity.ok(nome);
    }

    @GetMapping("/{id}")
    public ResponseEntity getDocument(@PathVariable Long id){

        return ResponseEntity.ok(documentService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        documentService.delete(id);
        return ResponseEntity.ok("Ok");
    }
}
