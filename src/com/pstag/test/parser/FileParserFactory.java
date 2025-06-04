package com.pstag.test.parser;

public class FileParserFactory {
    public static FileParser getParser(String filename) {
        if (filename.endsWith(".csv")) {
            return new CSVParser();
        } else if (filename.endsWith(".xml")) {
            return new XMLParser();
        } else {
            throw new IllegalArgumentException("Unsupported file format: " + filename);
        }
    }
}
