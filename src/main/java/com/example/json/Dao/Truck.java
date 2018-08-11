package com.example.json.Dao;

/**
 * Created by gshan on 2018/8/10
 */
public class Truck {
    private String VIN;
    private String color;
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
        return "Truck{" +
                "VIN='" + VIN + '\'' +
                ", color='" + color + '\'' +
                ", miles=" + miles +
                '}';
    }
}
