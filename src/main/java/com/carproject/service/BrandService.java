package com.carproject.service;

import com.carproject.model.Brand;
import com.carproject.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    @Autowired
    BrandRepository brandRepository;

    public List<Brand> getAll(){
        List<Brand> brands =  brandRepository.findAll();
        return brands;
    }

    public Brand post(Brand brand){
        brandRepository.save(brand);
        return brand;
    }

    public ResponseEntity getById(Long id){
        Assert.notNull(id, "Não foi encontrar pois está sem o ID");
        Optional<Brand> brand = brandRepository.findById(id);

        if(brand.isPresent()){
            return ResponseEntity.ok(brand);
        }
        return ResponseEntity.notFound().build();

    }

    public Brand updateBrand(Long id, Brand brand){
        Assert.notNull(id, "Não foi possível atualizar o registro");

        Optional<Brand> brandOptional = brandRepository.findById(id);

        if (brandOptional.isPresent()){
            brand.setIdBrand(brandOptional.get().getIdBrand());
            post(brand);

            return brand;
        }
        throw new RuntimeException("Não foi possível localizar o Brand no DBA");
    }

    public ResponseEntity delete(Long id){
        Assert.notNull(id, "Não foi encontrar pois está sem o ID");
        Optional<Brand> brand = brandRepository.findById(id);

        if(brand.isPresent()){
            brandRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
