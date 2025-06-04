package com.pstag.test.utils;

import com.pstag.test.model.Car;

import java.util.*;

public class XMLFormatter implements OutputFormatter {
    @Override
    public void format(List<Car> cars) {
        System.out.println("<cars>");
        for (Car c : cars) {
            System.out.println("  <car>");
            if(c.getBrand().equalsIgnoreCase("")) {
                System.out.println("    <model>" + c.getModel() + "</model>");
            } else {
                System.out.println("    <brand>" + c.getBrand() + "</brand>");
            }
            System.out.println("    <price>" + c.getPrice() + "</price>");
            System.out.println("    <releaseDate>" + c.getReleaseDate() + "</releaseDate>");
            System.out.println("    <type>" + c.getType() + "</type>");
            System.out.println("    <currency>" + c.getCurrency() + "</currency>");
            System.out.println("  </car>");
        }
        System.out.println("</cars>");
    }
}