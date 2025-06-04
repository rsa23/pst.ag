package com.pstag.test.utils;

public class OutputFormatterFactory {
    public static OutputFormatter getFormatter(String format) {
        switch (format.toLowerCase()) {
            case "table":
                return new TableFormatter();
            case "xml":
                return new XMLFormatter();
            case "json":
                return new JSONFormatter();
            default:
                throw new IllegalArgumentException("Unsupported output format: " + format);
        }
    }
}
