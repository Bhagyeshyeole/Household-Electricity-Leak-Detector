import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create Scanner for user input
        Scanner sc = new Scanner(System.in);

        // Create project objects
        ApplianceManager manager = new ApplianceManager();

        ElectricityCalculator electricityCalculator =
                new ElectricityCalculator();

        BillCalculator billCalculator =
                new BillCalculator();

        ConsumptionAnalyzer analyzer =
                new ConsumptionAnalyzer();

        SavingsCalculator savingsCalculator =
                new SavingsCalculator();

        FileManager fileManager = new FileManager();

        InputValidator validator = new InputValidator();

        // Load saved appliances
        manager.loadData(fileManager);

        // Electricity rate
        double electricityRate = 7;

        int choice = 0;

        // Keep showing menu until Exit
        while (choice != 6) {

            System.out.println("\n========================================");
            System.out.println("   HOUSEHOLD ELECTRICITY LEAK DETECTOR");
            System.out.println("========================================");
            System.out.println("1. Add Appliance");
            System.out.println("2. View Appliances");
            System.out.println("3. Calculate Bill");
            System.out.println("4. Analyze Consumption");
            System.out.println("5. Calculate Savings");
            System.out.println("6. Exit");
            System.out.println("========================================");

            // Read menu choice safely
            while (true) {

                System.out.print("Enter your choice: ");

                try {

                    choice = Integer.parseInt(sc.nextLine());

                    if (!validator.isValidMenuChoice(choice)) {
                        System.out.println(
                                "Invalid choice. Please select 1 to 6.");
                        continue;
                    }

                    break;

                } catch (NumberFormatException e) {

                    System.out.println(
                            "Invalid input. Please enter a number.");
                }
            }

            // Add appliance
            if (choice == 1) {

                String name;

                // Read appliance name
                while (true) {

                    System.out.print("Enter appliance name: ");
                    name = sc.nextLine();

                    if (validator.isValidName(name)) {
                        break;
                    }

                    System.out.println(
                            "Invalid name. Name cannot be empty.");
                }

                double wattage;

                // Read wattage safely
                while (true) {

                    System.out.print("Enter wattage (W): ");

                    try {

                        wattage = Double.parseDouble(sc.nextLine());

                        if (validator.isValidWattage(wattage)) {
                            break;
                        }

                        System.out.println(
                                "Invalid wattage. Enter a value greater than 0.");

                    } catch (NumberFormatException e) {

                        System.out.println(
                                "Invalid input. Please enter a number.");
                    }
                }

                double hoursPerDay;

                // Read usage hours safely
                while (true) {

                    System.out.print(
                            "Enter usage hours per day: ");

                    try {

                        hoursPerDay =
                                Double.parseDouble(sc.nextLine());

                        if (validator.isValidHours(hoursPerDay)) {
                            break;
                        }

                        System.out.println(
                                "Invalid hours. Enter a value between 0 and 24.");

                    } catch (NumberFormatException e) {

                        System.out.println(
                                "Invalid input. Please enter a number.");
                    }
                }

                // Create appliance
                Appliance appliance =
                        new Appliance(name, wattage, hoursPerDay);

                // Add appliance
                manager.addAppliance(appliance);

                // Save appliance
                manager.saveData(fileManager);

                System.out.println(
                        "Appliance added and saved successfully.");
            }

            // View appliances
            else if (choice == 2) {

                manager.displayAllAppliances();
            }

            // Calculate bill
            else if (choice == 3) {

                if (manager.getApplianceCount() == 0) {

                    System.out.println(
                            "No appliances available.");

                } else {

                    double totalMonthlyConsumption = 0;

                    for (Appliance appliance :
                            manager.getAppliances()) {

                        double dailyConsumption =
                                electricityCalculator
                                        .calculateDailyConsumption(
                                                appliance.wattage,
                                                appliance.hoursPerDay);

                        double monthlyConsumption =
                                electricityCalculator
                                        .calculateMonthlyConsumption(
                                                dailyConsumption);

                        totalMonthlyConsumption +=
                                monthlyConsumption;
                    }

                    double totalBill =
                            billCalculator.calculateMonthlyBill(
                                    totalMonthlyConsumption,
                                    electricityRate);

                    System.out.printf(
                            "Total Monthly Consumption: %.2f kWh%n",
                            totalMonthlyConsumption);

                    System.out.printf(
                            "Electricity Rate: ₹%.2f per unit%n",
                            electricityRate);

                    System.out.printf(
                            "Estimated Monthly Bill: ₹%.2f%n",
                            totalBill);
                }
            }

            // Analyze consumption
            else if (choice == 4) {

                if (manager.getApplianceCount() == 0) {

                    System.out.println(
                            "No appliances available.");

                } else {

                    System.out.println(
                            "\n===== CONSUMPTION ANALYSIS =====");

                    for (Appliance appliance :
                            manager.getAppliances()) {

                        analyzer.analyzeAppliance(appliance);
                    }
                }
            }

            // Calculate savings
            else if (choice == 5) {

                if (manager.getApplianceCount() == 0) {

                    System.out.println(
                            "No appliances available.");

                } else {

                    double currentWattage;

                    // Read current wattage safely
                    while (true) {

                        System.out.print(
                                "Enter current appliance wattage (W): ");

                        try {

                            currentWattage =
                                    Double.parseDouble(
                                            sc.nextLine());

                            if (validator.isValidWattage(
                                    currentWattage)) {
                                break;
                            }

                            System.out.println(
                                    "Invalid wattage. Enter a value greater than 0.");

                        } catch (NumberFormatException e) {

                            System.out.println(
                                    "Invalid input. Please enter a number.");
                        }
                    }

                    double newWattage;

                    // Read replacement wattage safely
                    while (true) {

                        System.out.print(
                                "Enter replacement appliance wattage (W): ");

                        try {

                            newWattage =
                                    Double.parseDouble(
                                            sc.nextLine());

                            if (validator.isValidWattage(newWattage)) {
                                break;
                            }

                            System.out.println(
                                    "Invalid replacement wattage.");

                        } catch (NumberFormatException e) {

                            System.out.println(
                                    "Invalid input. Please enter a number.");
                        }
                    }

                    double hoursPerDay;

                    // Read usage hours safely
                    while (true) {

                        System.out.print(
                                "Enter usage hours per day: ");

                        try {

                            hoursPerDay =
                                    Double.parseDouble(
                                            sc.nextLine());

                            if (validator.isValidHours(hoursPerDay)) {
                                break;
                            }

                            System.out.println(
                                    "Invalid hours. Enter a value between 0 and 24.");

                        } catch (NumberFormatException e) {

                            System.out.println(
                                    "Invalid input. Please enter a number.");
                        }
                    }

                    // Calculate current consumption
                    double currentConsumption =
                            savingsCalculator
                                    .calculateMonthlyConsumption(
                                            currentWattage,
                                            hoursPerDay);

                    // Calculate new consumption
                    double newConsumption =
                            savingsCalculator
                                    .calculateMonthlyConsumption(
                                            newWattage,
                                            hoursPerDay);

                    // Calculate energy saving
                    double energySaving =
                            savingsCalculator
                                    .calculateMonthlySaving(
                                            currentConsumption,
                                            newConsumption);

                    // Calculate monthly money saving
                    double monthlyMoneySaving =
                            savingsCalculator
                                    .calculateMonthlyMoneySaving(
                                            energySaving,
                                            electricityRate);

                    // Calculate annual money saving
                    double annualMoneySaving =
                            savingsCalculator
                                    .calculateAnnualMoneySaving(
                                            monthlyMoneySaving);

                    System.out.println(
                            "\n----------- SAVINGS RESULT -----------");

                    System.out.printf(
                            "Current Consumption: %.2f kWh/month%n",
                            currentConsumption);

                    System.out.printf(
                            "New Consumption: %.2f kWh/month%n",
                            newConsumption);

                    System.out.printf(
                            "Energy Saved: %.2f kWh/month%n",
                            energySaving);

                    System.out.printf(
                            "Money Saved: ₹%.2f/month%n",
                            monthlyMoneySaving);

                    System.out.printf(
                            "Money Saved: ₹%.2f/year%n",
                            annualMoneySaving);
                }
            }

            // Exit
            else if (choice == 6) {

                System.out.println(
                        "Thank you for using Household Electricity Leak Detector.");
            }
        }

        // Close Scanner
        sc.close();
    }
}