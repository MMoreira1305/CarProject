package com.carproject.controller;

import com.carproject.model.Brand;
import com.carproject.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    @GetMapping
    public ResponseEntity<?> getAllBrands(){
        try{
            return new ResponseEntity<>(brandService.getAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping
    public ResponseEntity postBrand(@RequestBody Brand brand){
        brandService.post(brand);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getBrand(@PathVariable Long id){
        return brandService.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity putBrand(@PathVariable Long id, @RequestBody Brand brand){
        Brand newBrand = brandService.updateBrand(id, brand);
        return ResponseEntity.ok(newBrand);
    }
}
