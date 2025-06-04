package com.pstag.test.utils;

import com.pstag.test.model.Car;

import java.util.List;

public class TableFormatter implements OutputFormatter {
    @Override
    public void format(List<Car> cars) {
        System.out.printf("%-12s %-10s %-12s %-10s %-10s%n", "Brand/Model", "Price", "Release Date", "Type", "Currency");
        for (Car c : cars) {
            System.out.printf("%-10s %-10s %-12s %-10s %-10.2f%n ",
                    c.getBrand().equalsIgnoreCase("") ? c.getModel() : c.getBrand(), c.getReleaseDate(), c.getType(), c.getCurrency(), c.getPrice());
        }
    }
}
