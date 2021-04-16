package com.example.P2carinfo.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    private CarManagerService carService;

    public CarController(CarManagerService carService) {
        this.carService = carService;
    }

    @PostMapping("/cars/create")
    public ResponseEntity<Car> createCar(@RequestBody Car car){
        HttpStatus status = HttpStatus.CREATED;
        Car saved = carService.save(car);

        return new ResponseEntity<>(saved, status);
    }

    @GetMapping("/cars")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @GetMapping(value = "/cars/{id}")
    public Car getCarById(@PathVariable Long id){
        return carService.getCarDetails(id);
    }

}

