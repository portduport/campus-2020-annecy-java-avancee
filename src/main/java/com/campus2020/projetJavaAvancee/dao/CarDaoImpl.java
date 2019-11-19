package com.campus2020.projetJavaAvancee.dao;

import com.campus2020.projetJavaAvancee.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao{
    private static List<Car> cars = new ArrayList<Car>();
    static {
        cars.add(new Car("Audi", "Q7"));
        cars.add(new Car("BMW", "325i"));
    }

    @Override
    public List<Car> findAll() {
        return cars;
    }

    @Override
    public Car findById(String id) {
        for (Car car : cars){
            if(car.getId().equals(id)){
                return car;
            }
        }
        return null;
    }

    @Override
    public Car save(Car car) {
        cars.add(car);
        return car;
    }

    @Override
    public Car update(Car car) {
        cars.add(car);
        return car;
    }

    @Override
    public void deleteById(String id) {
        Iterator itr = cars.iterator();
        while(itr.hasNext()){
            Car car = (Car)itr.next();
            if(car.getId().equals(id)){
                itr.remove();
            }
        }
    }

}
