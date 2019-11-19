package com.campus2020.projetJavaAvancee.web.controller;

import com.campus2020.projetJavaAvancee.model.Car;
import com.campus2020.projetJavaAvancee.dao.CarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarDao carDao;

    @GetMapping("/cars")
    public List<Car> listCars() {
        return carDao.findAll();
    }

    @PostMapping("/cars/")
    public Car saveCar(@RequestBody Car car) {
        return carDao.save(car);
    }

    @GetMapping("/cars/{id}")
    public Car showCar(@PathVariable String id) {
        return carDao.findById(id);
    }

    @PutMapping("/cars/{id}")
    public Car updateCar(@PathVariable String id, @RequestBody Car car) {
        car.setId(id);
        return carDao.update(car);
    }

    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable String id) {
        carDao.deleteById(id);
    }

}
