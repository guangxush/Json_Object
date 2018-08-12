package com.example.json.Services;


import com.example.json.Dao.Car;
import com.example.json.Dao.Truck;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by gshan on 2018/8/10
 */
@Component
public class RequestWrapper {
    List<Car> cars;
    Truck truck;

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    @Override
    public String toString() {
        return "RequestWrapper{" +
                "cars=" + cars +
                ", truck=" + truck +
                '}';
    }
}
