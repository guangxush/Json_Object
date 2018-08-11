package com.example.json.Controller;


import com.example.json.Dao.Car;
import com.example.json.Services.RequestWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by gshan on 2018/8/10
 */
@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @RequestMapping(value = "/car", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<Car> getcar() {

        Car car = new Car();
        car.setColor("Blue");
        car.setMiles(100);
        car.setVIN("1234");
        car.toString();
        return new ResponseEntity<Car>(car, HttpStatus.OK);
    }

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public ResponseEntity<Car> updatecar(@RequestBody Car car) {

        if (car != null) {
            car.setMiles(car.getMiles() + 100);
            car.toString();
        }
        // TODO: call persistence layer to update
        return new ResponseEntity<Car>(car, HttpStatus.OK);
    }

    @RequestMapping(value = "/cars", method = RequestMethod.POST)
    public ResponseEntity<List<Car>> updatecars(@RequestBody List<Car> cars) {

        cars.stream().forEach(c -> c.setMiles(c.getMiles() + 100));

        // TODO: call persistence layer to update
        return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
    }

    @RequestMapping(value = "/carsandtrucks", method = RequestMethod.POST)
    public ResponseEntity<RequestWrapper> updateWithMultipleObjects(
            @RequestBody RequestWrapper requestWrapper) {

        requestWrapper.getCars().stream()
                .forEach(c -> c.setMiles(c.getMiles() + 100));

        // TODO: call persistence layer to update
        return new ResponseEntity<RequestWrapper>(requestWrapper, HttpStatus.OK);
    }
}
