package com.example.json.Dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

/**
 * Created by gshan on 2018/8/10
 */
@Component
public class Car {
    //@JsonProperty(value= "VIN")
    private String VIN;

    //@JsonProperty(value= "color")
    private String color;

    //@JsonProperty(value= "miles")
    private Integer miles;

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getMiles() {
        return miles;
    }

    public void setMiles(Integer miles) {
        this.miles = miles;
    }

    @Override
    public String toString() {
        return "Car{" +
                "vIN='" + VIN + '\'' +
                ", color='" + color + '\'' +
                ", miles=" + miles +
                '}';
    }
}
