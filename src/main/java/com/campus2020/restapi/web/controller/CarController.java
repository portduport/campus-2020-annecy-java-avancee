package com.campus2020.restapi.web.controller;

import com.campus2020.restapi.exception.ResourceNotFoundException;
import com.campus2020.restapi.model.Car;
import com.campus2020.restapi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/cars")
    public List<Car> listCars() {
        return carRepository.findAll();
    }

    @PostMapping(value = "/cars")
    public Car saveCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @GetMapping("/cars/{id}")
    public Car showCar(@PathVariable int id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car", "id", id));
    }

    @PutMapping("/cars/{id}")
    public Car updateCar(@PathVariable int id, @RequestBody Car carDetails) {
        Car currentCar = this.showCar(id);

        if (carDetails.getBrand() != null) {
            currentCar.setBrand(carDetails.getBrand());
        }
        if (carDetails.getVersion() != null) {
            currentCar.setVersion(carDetails.getVersion());
        }
        return carRepository.save(currentCar);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable int id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car", "id", id));

        carRepository.delete(car);

        return ResponseEntity.ok().build();
    }

}
