package com.pstag.test.parser;

import com.pstag.test.model.Car;

import java.util.List;

public interface FileParser {
    List<Car> parse(String filePath) throws Exception;
}
