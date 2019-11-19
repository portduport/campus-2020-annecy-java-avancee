package com.campus2020.projetJavaAvancee.dao;

import com.campus2020.projetJavaAvancee.model.Car;

import java.util.List;

public interface CarDao {
    public List<Car> findAll();
    public Car findById(int id);
    public Car save(Car car);
    public Car update(Car car);
    public void deleteById(int id);
}
