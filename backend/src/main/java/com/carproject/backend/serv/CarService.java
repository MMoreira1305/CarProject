package com.carproject.backend.serv;

import com.carproject.backend.dto.CarDTO;
import com.carproject.backend.model.Car;
import com.carproject.backend.repo.BrandRepository;
import com.carproject.backend.repo.CarRepository;
import com.carproject.backend.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<Car> getAll(){
        List<Car> carros =  carRepository.findAll();
        return carros;
    }

    public CarDTO post(Car car){
        carRepository.save(car);
        CarDTO carDTO = new CarDTO(car, brandRepository, categoryRepository);
        return carDTO;
    }

    public ResponseEntity getById(Long id){
        Assert.notNull(id, "Não foi encontrar pois está sem o ID");
        Optional<Car> car = carRepository.findById(id);

        if(car.isPresent()){
            CarDTO carDTO = new CarDTO(car.get(), brandRepository, categoryRepository);
            return ResponseEntity.ok(carDTO);
        }
        return ResponseEntity.notFound().build();

    }

    public ResponseEntity getByPlate(String plate) {
        Assert.notNull(plate, "Não foi possível atualizar o registro pois não foi passado a placa");
        Optional<Car> car = carRepository.findByPlate(plate);

        if(car.isPresent()){
            CarDTO carDTO = new CarDTO(car.get(), brandRepository, categoryRepository);
            return ResponseEntity.ok(carDTO);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity getByName(String name) {
        Assert.notNull(name, "Não foi possível atualizar o registro pois não foi passado o nome");
        Optional<Car> car = carRepository.findByName(name);

        if(car.isPresent()){
            CarDTO carDTO = new CarDTO(car.get(), brandRepository, categoryRepository);
            return ResponseEntity.ok(carDTO);
        }
        return ResponseEntity.notFound().build();
    }

    public CarDTO updateCar(Long id, Car car){
        Assert.notNull(id, "Não foi possível atualizar o registro");

        Optional<Car> carInDBA = carRepository.findById(id);

        if (carInDBA.isPresent()){
            car.setId(carInDBA.get().getId());
            post(car);
            CarDTO carDTO = new CarDTO(car, brandRepository, categoryRepository);

            return carDTO;
        }
        else {
            throw new RuntimeException("Não foi possível localizar o carro no DBA");
        }
    }

    public void delete(Long id){
        carRepository.deleteById(id);
    }
}
