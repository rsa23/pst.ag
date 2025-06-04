package com.pstag.test.utils;

import com.pstag.test.model.Car;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class FilterUtil {
    public static List<Car> applyFilters(List<Car> cars, Map<String, String> filters) {
        Stream<Car> stream = cars.stream();

        if (filters.containsKey("brand")) {
            String brand = filters.get("brand");
            stream = stream.filter(c -> c.getBrand().equalsIgnoreCase(brand));
        }

        if (filters.containsKey("type")) {
            String type = filters.get("type");
            stream = stream.filter(c -> c.getType().equalsIgnoreCase(type));
        }

        if (filters.containsKey("price")) {
            double price = Double.parseDouble(filters.get("price"));
            stream = stream.filter(c -> c.getPrice() <= price);
        }

        if (filters.containsKey("releaseDate")) {
            LocalDate date = LocalDate.parse(filters.get("releaseDate"));
            stream = stream.filter(c -> c.getReleaseDate().equals(date));
        }

        return stream.collect(Collectors.toList());
    }
}
