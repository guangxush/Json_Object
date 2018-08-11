package com.example.json.Dao;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by gshan on 2018/8/10
 */
public class Car {
    //@JsonProperty(value= "VIN")
    private String vIN;

    //@JsonProperty(value= "color")
    private String color;

    //@JsonProperty(value= "miles")
    private Integer miles;

    public String getVIN() {
        return vIN;
    }

    public void setVIN(String vIN) {
        this.vIN = vIN;
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
                "VIN='" + vIN + '\'' +
                ", color='" + color + '\'' +
                ", miles=" + miles +
                '}';
    }
}
