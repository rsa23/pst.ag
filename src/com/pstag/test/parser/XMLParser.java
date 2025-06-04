package com.pstag.test.parser;

import com.pstag.test.model.Car;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class XMLParser implements FileParser {
    public List<Car> parse(String filePath) throws Exception {
        List<Car> cars = new ArrayList<>();

        Document doc = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .parse(new File(filePath));
        doc.getDocumentElement().normalize();

        NodeList carNodes = doc.getElementsByTagName("car");

        for (int i = 0; i < carNodes.getLength(); i++) {
            Element carElement = (Element) carNodes.item(i);
            String brand = getText(carElement, "brand");
            String model = getText(carElement, "model");
            String type = getText(carElement, "type");

            // Default price from first <price currency="USD">
            Element basePriceElement = (Element) carElement.getElementsByTagName("price").item(0);
            String baseCurrency = basePriceElement.getAttribute("currency");
            double basePrice = Double.parseDouble(basePriceElement.getTextContent());

            double finalPrice = basePrice;
            String finalCurrency = baseCurrency;

            // Optional override based on car type
            NodeList priceList = ((Element) carElement.getElementsByTagName("prices").item(0)).getElementsByTagName("price");
            for (int j = 0; j < priceList.getLength(); j++) {
                Element p = (Element) priceList.item(j);
                String cur = p.getAttribute("currency").trim();
                double val = Double.parseDouble(p.getTextContent().trim());

                if ((type.equalsIgnoreCase("SUV") && cur.equals("EUR")) ||
                        (type.equalsIgnoreCase("Sedan") && cur.equals("JPY")) ||
                        (type.equalsIgnoreCase("Truck") && cur.equals("USD"))) {
                    finalPrice = val;
                    finalCurrency = cur;
                    break;
                }
            }

            LocalDate releaseDate = LocalDate.now(); // Placeholder

            cars.add(new Car(brand, finalPrice, releaseDate, model, type, finalCurrency));
        }

        return cars;
    }

    private String getText(Element parent, String tag) {
        NodeList nodes = parent.getElementsByTagName(tag);
        if (nodes.getLength() > 0) {
            return nodes.item(0).getTextContent().trim();
        }
        return "";
    }
}
