package org.db;

import org.service.Car;

import java.util.ArrayList;
import java.util.List;

public class CarDatabase {
    private List<Car> carList;

    public CarDatabase() {
        this.carList = new ArrayList<>();
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public Car getCarById(int carId) {
        for (Car car : carList) {
            if (car.getId() == carId) {
                return car;
            }
        }
        return null;
    }

    public List<Car> getCarsByUserId(int userId) {
        List<Car> userCars = new ArrayList<>();
        for (Car car : carList) {
            if (car.getUserId() == userId) {
                userCars.add(car);
            }
        }
        return userCars;
    }

    public boolean updateCar(Car updatedCar) {
        for (int i = 0; i < carList.size(); i++) {
            Car currentCar = carList.get(i);
            if (currentCar.getId() == updatedCar.getId()) {
                carList.set(i, updatedCar);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCar(int carId) {
        for (Car car : carList) {
            if (car.getId() == carId) {
                carList.remove(car);
                return true;
            }
        }
        return false;
    }
}
