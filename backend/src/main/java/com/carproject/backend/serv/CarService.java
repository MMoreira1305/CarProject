package com.carproject.backend.serv;

import com.carproject.backend.dto.CarDTO;
import com.carproject.backend.model.Car;
import com.carproject.backend.model.Document;
import com.carproject.backend.repo.BrandRepository;
import com.carproject.backend.repo.CarRepository;
import com.carproject.backend.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    DocumentService documentService;

    @Autowired
    CarRepository carRepository;

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<Car> getAllActives(){
        List<Car> carros =  carRepository.findBySituation("ATIVO");
        return carros;
    }

    public List<Car> getAllInactives(){
        List<Car> carros =  carRepository.findBySituation("INATIVO");
        return carros;
    }

    public List<Car> getAll(){
        List<Car> carros =  carRepository.findAll();
        return carros;
    }

    public CarDTO post(Car car){
        try{
            carRepository.save(car);
            System.out.println("CHEGOU AQUI");
            CarDTO carDTO = new CarDTO(car, brandRepository, categoryRepository);

            System.out.println("CHEGOU AQUI");
            Optional<Car> carOptional = carRepository.findByPlate(car.getPlate());

            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            String todaysdate = dateFormat.format(date);

            Date horaAtual = new Date();
            // Formata a hora atual como uma string
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            String horaAtualString = format.format(horaAtual);
            Document document = new Document(null, carOptional.get(), todaysdate, horaAtualString, "ATIVADO", car.getQuantity());
            documentService.post(document);
            return carDTO;
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }

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

            Optional<Car> carOptional = carRepository.findById(id);

            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            String todaysdate = dateFormat.format(date);

            SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
            Calendar calHour = Calendar.getInstance();
            Date dateHour = cal.getTime();
            String horaAtual = dateFormat.format(date);

            if(car.getQuantity() < carInDBA.get().getQuantity()){
                int moviment = carInDBA.get().getQuantity() - car.getQuantity();
                Document document = new Document(carOptional.get(), todaysdate, horaAtual , "RETIRADA", moviment);
                documentService.post(document);
            }else if(car.getQuantity() > carInDBA.get().getQuantity()){
                int moviment = car.getQuantity() - carInDBA.get().getQuantity();
                Document document = new Document(carOptional.get(), todaysdate, horaAtual , "ENTRADA", moviment);
                documentService.post(document);
            }


            CarDTO carDTO = new CarDTO(car, brandRepository, categoryRepository);

            return carDTO;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public void delete(Long id){
        Optional<Car> carOptional = carRepository.findById(id);

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String todaysdate = dateFormat.format(date);

        SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
        Calendar calHour = Calendar.getInstance();
        Date dateHour = cal.getTime();
        String horaAtual = dateFormat.format(date);

        if(carOptional.isPresent()){
            Car car = carOptional.get();
            car.setSituation("INATIVO");

            Document document = new Document(null, car, todaysdate, horaAtual, "INATIVADO", car.getQuantity());
            documentService.post(document);
        }

        else {
            throw new IllegalArgumentException("Id não encontrado");
        }
    }
}
