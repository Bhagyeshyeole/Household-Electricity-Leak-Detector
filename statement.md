# Household Electricity Leak Detector

## Problem Statement

Many household users know that their electricity bill is high but may not know which appliances are contributing most to their electricity consumption.

Checking appliance wattage and usage manually can also make it difficult to estimate monthly consumption and understand the possible cost.

The Household Electricity Leak Detector is designed as a simple command-line application that accepts appliance information, calculates electricity consumption, estimates the monthly bill, and identifies appliances with unusually high consumption using predefined rules.

The project uses rule-based analysis and does not use artificial intelligence or machine learning.

## Scope of the Project

The project focuses on appliance-level household electricity consumption.

The application allows users to:

- Add and view household appliances
- Store appliance information using CSV storage
- Calculate daily and monthly electricity consumption
- Calculate an estimated monthly electricity bill
- Analyze appliance consumption using predefined thresholds
- Compare current and replacement appliance wattage
- Estimate monthly and yearly savings
- Validate user input
- Handle invalid numeric input

The term "leak detector" in this project refers to identifying unusually high or excessive electricity consumption. The application does not detect physical electrical wiring faults, current leakage, voltage problems, or hardware faults.

## Target Users

The project is intended for users who want a simple way to understand and monitor household electricity consumption.

Potential users include:

- Household users
- Students living in hostels or rented rooms
- People living in rented homes
- Small office users interested in basic electricity monitoring

## High-Level Features

### 1. Appliance Management

Users can add appliances and view the appliances stored by the application.

### 2. Electricity Consumption and Bill Calculation

The system calculates daily consumption, monthly consumption, and an estimated monthly electricity bill based on appliance usage and electricity rate.

### 3. Consumption Analysis

The system classifies appliance consumption as Normal, Moderate, or High using predefined project rules.

### 4. Savings Analysis

Users can compare a current appliance with a lower-wattage replacement and estimate possible monthly and yearly monetary savings.

### 5. CSV Data Storage

Appliance information is saved in `data/appliances.csv` and loaded when the application starts.

### 6. Input Validation and Exception Handling

The application checks invalid values and handles incorrect numeric input without unnecessarily terminating the program.