package com.example.P2carinfo.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarManagerService {

    private CarRepository carRepository;

    public CarManagerService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public Car getCarDetails(Long id){
        return carRepository.findByCarId(id);
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }
}
