package com.campus2020.restapi.dao;

import com.campus2020.restapi.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
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
    public Car findById(int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
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
        Car currentCar = this.findById(car.getId());
            if (currentCar.getId() == car.getId()) {
                if (car.getBrand() != null) {
                    currentCar.setBrand(car.getBrand());
                }
                if (car.getVersion() != null) {
                    currentCar.setVersion(car.getVersion());
                }
                return currentCar;
            }
            return null;
        }


    @Override
    public void deleteById(int id) {
        Iterator itr = cars.iterator();
        while (itr.hasNext()) {
            Car car = (Car) itr.next();
            if (car.getId() == id) {
                itr.remove();
            }
        }
    }

}
