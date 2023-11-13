package com.carproject.backend.dto;

import com.carproject.backend.model.Brand;
import com.carproject.backend.model.Car;
import com.carproject.backend.model.Category;
import com.carproject.backend.repository.BrandRepository;
import com.carproject.backend.repository.CategoryRepository;
import lombok.Data;

import java.util.Optional;

@Data
public class CarDTO {

    private Long id;
    private String plate;
    private Long odometer;
    private String color;
    private Double price;
    private int quantity;
    private String name;
    private String name_brand;
    private String name_category;

    public CarDTO (Car carro, BrandRepository brandRepository, CategoryRepository categoryRepository){
        this.id = carro.getId();
        this.plate = carro.getPlate();
        this.odometer = carro.getOdometer();
        this.color = carro.getColor();
        this.price = carro.getPrice();
        this.quantity = carro.getQuantity();
        this.name = carro.getName();

        Optional<Brand> brand = brandRepository.findById(carro.getBrand().getIdBrand());
        this.name_brand = brand.get().getName();

        Optional<Category> category = categoryRepository.findById(carro.getCategory().getId());
        this.name_category = category.get().getNameCategory();
    }

    public CarDTO (){

    }
}
