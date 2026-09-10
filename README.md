# Household Electricity Leak Detector

## Overview

Household Electricity Leak Detector is a Java-based command-line application for checking household appliance electricity consumption.

The project takes basic appliance details such as appliance name, wattage, and usage hours per day. It then calculates electricity consumption and gives an estimated monthly electricity bill. It also checks monthly consumption using predefined rules and identifies appliances with high consumption.

The project also includes a savings calculation feature. This allows a user to compare the electricity usage of a current appliance with a lower-wattage replacement and estimate the possible monthly and yearly saving.

The application does not use artificial intelligence or machine learning. The consumption analysis is based on simple rules defined in the project.

## Features

- Add household appliances
- View saved appliances
- Calculate monthly electricity consumption
- Calculate estimated monthly electricity bill
- Analyze appliance consumption as Normal, Moderate, or High
- Compare current and replacement appliance wattage
- Calculate monthly and yearly money savings
- Save appliance data in a CSV file
- Load saved appliance data when the program starts
- Validate user input
- Handle invalid numeric input without terminating the program

## Technologies and Tools

- Java
- Java Standard Library
- ArrayList
- CSV file storage
- Visual Studio Code
- Git
- GitHub

## Project Structure

```text
Household-Electricity-Leak-Detector/
│
├── data/
│   └── appliances.csv
│
├── docs/
│   └── diagrams/
│       ├── system-architecture.png
│       ├── process-flow.png
│       ├── use-case-diagram.png
│       ├── class-diagram.png
│       ├── sequence-diagram.png
│       └── csv-storage-design.png
│
├── tests/
│   └── test-results.txt
│
├── Appliance.java
├── ApplianceManager.java
├── ElectricityCalculator.java
├── BillCalculator.java
├── ConsumptionAnalyzer.java
├── SavingsCalculator.java
├── FileManager.java
├── InputValidator.java
├── Main.java
├── README.md
└── statement.md