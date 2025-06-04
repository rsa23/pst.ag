package com.pstag.test.utils;

import com.pstag.test.model.Car;

import java.util.*;

public class JSONFormatter implements OutputFormatter {
    @Override
    public void format(List<Car> cars) {
        System.out.println("[");
        for (int i = 0; i < cars.size(); i++) {
            Car c = cars.get(i);
            System.out.println("  {");
            if(c.getBrand().equalsIgnoreCase("")) {
                System.out.println("    \"model\": \"" + c.getModel() + "\",");
            } else {
                System.out.println("    \"brand\": \"" + c.getBrand() + "\",");
            }
            System.out.println("    \"price\": " + c.getPrice() + ",");
            System.out.println("    \"releaseDate\": \"" + c.getReleaseDate() + "\",");
            System.out.println("    \"type\": \"" + c.getType() + "\",");
            System.out.println("    \"currency\": \"" + c.getCurrency() + "\"");
            System.out.print("  }");
            if (i < cars.size() - 1) System.out.println(","); else System.out.println();
        }
        System.out.println("]");
    }
}