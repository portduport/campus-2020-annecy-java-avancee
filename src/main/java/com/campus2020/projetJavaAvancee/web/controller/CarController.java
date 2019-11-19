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

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public List<Car> listCars(){
        return carDao.findAll();
    }

    @RequestMapping(value = "/cars/{id}", method = RequestMethod.GET)
    public Car showCar(@PathVariable String id){
        return carDao.findById(id);
    }

    @RequestMapping(value = "cars/create", method = RequestMethod.POST)
    public Car saveCar(@RequestBody Car car){
        return carDao.save(car);
    }

    @RequestMapping(value = "/cars/update/{id}", method = RequestMethod.PUT)
    public Car updateCar(@PathVariable String id){
        Car car = carDao.findById(id);
        return carDao.update(car);
    }

    @RequestMapping(value = "/cars/delete/{id}", method = RequestMethod.DELETE)
    public void deleteCar(@PathVariable String id){
        carDao.deleteById(id);
    }

}
