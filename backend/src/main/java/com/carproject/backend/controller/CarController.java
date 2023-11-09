package com.carproject.backend.controller;

import com.carproject.backend.dto.CarDTO;
import com.carproject.backend.model.Car;
import com.carproject.backend.serv.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping
    public ResponseEntity getAllProducts(){
        List<Car> cars = carService.getAll();
        return ResponseEntity.ok(cars);
    }

    @PostMapping
    public ResponseEntity postProduct(@RequestBody Car car){
        CarDTO carDTO = carService.post(car);
        return ResponseEntity.ok(carDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        carService.delete(id);
        return ResponseEntity.ok("ok");
    }



    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        return carService.getById(id);
    }

    @GetMapping("/{name}")
    public ResponseEntity getByName(@PathVariable String name){
        return carService.getByName(name);
    }

    @GetMapping("/{plate}")
    public ResponseEntity getByPlate(@PathVariable String plate){

        return carService.getByPlate(plate);
    }

    @PutMapping("/{id}")
    public ResponseEntity putOnlyProduct(@PathVariable Long id, @RequestBody Car car) {
        CarDTO carDTO = carService.updateCar(id, car);

        return carDTO != null ?
                ResponseEntity.ok(carDTO) :
                ResponseEntity.notFound().build();
    }
}
