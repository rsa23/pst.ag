package com.pstag.test.utils;

import com.pstag.test.model.Car;
import java.util.*;

public class SortUtil {
    public static List<Car> sort(List<Car> cars, String option) {
        switch (option.toLowerCase()) {
            case "release":
                cars.sort((a, b) -> b.getReleaseDate().compareTo(a.getReleaseDate()));
                break;
            case "price":
                cars.sort((a, b) -> Double.compare(b.getPrice(), a.getPrice()));
                break;
        }
        return cars;
    }
}
