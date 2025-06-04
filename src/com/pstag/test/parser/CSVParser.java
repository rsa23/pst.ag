package com.pstag.test.parser;

import com.pstag.test.model.Car;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CSVParser implements FileParser {
    private Map<String, LocalDate> releaseDateMap;

    @Override
        public List<Car> parse(String filePath) throws Exception {
            List<Car> cars = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            br.readLine(); // skip header

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",", -1); // -1 keeps empty strings

                if (fields.length < 2) continue;

                String brand = fields[0].trim().replaceAll("\"", "").trim();
                String dateStr = fields[1].trim();
                LocalDate releaseDate = LocalDate.parse(dateStr.replaceAll("\"", "").trim(), formatter);

                // The CSV only contains brand and releaseDate
                // Other fields are set with placeholders or defaults
                double price = 0.0;
                String model = "";
                String type = "";
                String currency = "";

                cars.add(new Car(brand, price, releaseDate, model, type, currency));
            }

            br.close();
            return cars;
        }
}
