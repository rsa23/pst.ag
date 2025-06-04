package com.pstag.test.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class ReleaseDateMapper {
    public static Map<String, LocalDate> load(String filePath) throws Exception {
        Map<String, LocalDate> brandDateMap = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        boolean first = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        while ((line = reader.readLine()) != null) {
            if (first) {
                first = false;
                continue;
            }
            String[] parts = line.split(",");
            if (parts.length < 2) continue;
            String brand = parts[0].trim();
            LocalDate date = LocalDate.parse(parts[1].trim(), formatter);
            brandDateMap.put(brand, date);
        }
        reader.close();
        return brandDateMap;
    }
}
