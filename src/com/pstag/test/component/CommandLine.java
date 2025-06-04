package com.pstag.test.component;

import java.util.HashMap;
import java.util.Map;

public class CommandLine {
    private String inputFile;
    private String outputFormat;
    private String sortOption;
    private Map<String, String> filters = new HashMap<>();

    public CommandLine(String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--input":
                    inputFile = args[++i];
                    break;
                case "--filter":
                    String[] parts = args[++i].split("=");
                    if (parts.length == 2) filters.put(parts[0], parts[1]);
                    break;
                case "--sort":
                    sortOption = args[++i];
                    break;
                case "--output":
                    outputFormat = args[++i];
                    break;

            }
        }
    }

    public String getInputFile() { return inputFile; }
    public String getOutputFormat() { return outputFormat; }
    public String getSortOption() { return sortOption; }
    public boolean hasFilters() { return !filters.isEmpty(); }
    public Map<String, String> getFilters() { return filters; }
}
