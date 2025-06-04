# Car Processing and Parsing Data

A Java 8 command-line application to load car data from **CSV** or **XML** files, apply **filtering** and **sorting**, and export results in **table**, **JSON**, or **XML** format.

## Features

- Load data from `.csv` or `.xml` files
- Filter by fields like `brand`, `model`, `releaseDate`, `price`
- Sort by `releaseDate`, `price`
- Output as table, JSON, or XML

### Basic Command Format
- CLI
java -jar CarApp.jar --input <file> [--filter key=value,...] [--sort value] [--output table|xml|json]
