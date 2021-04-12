package com.example.P2carinfo.car;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carId;

    private String maker;
    private String model;

    public Car() {

    }

    public Car(String model, String maker) {
        this.model = model;
        this.maker = maker;
    }

    public Long getCarId() {
        return carId;
    }

    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public void setModel(String model) {
        this.model = model;
    }




}