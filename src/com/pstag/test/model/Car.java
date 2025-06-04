package com.pstag.test.model;

import java.time.LocalDate;

public class Car {
    private String brand;
    private double price;
    private LocalDate releaseDate;
    private String model;
    private String type;
    private String currency;

    public Car(String brand, double price, LocalDate releaseDate, String model, String type, String currency) {
        this.brand = brand;
        this.price = price;
        this.releaseDate = releaseDate;
        this.model = model;
        this.type = type;
        this.currency = currency;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
