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

        // Load previously saved appliances
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

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            // Add appliance
            if (choice == 1) {

                sc.nextLine();

                System.out.print("Enter appliance name: ");
                String name = sc.nextLine();

                System.out.print("Enter wattage (W): ");
                double wattage = sc.nextDouble();

                System.out.print("Enter usage hours per day: ");
                double hoursPerDay = sc.nextDouble();

                Appliance appliance =
                        new Appliance(name, wattage, hoursPerDay);

                // Add appliance to manager
                manager.addAppliance(appliance);

                // Save updated list to CSV
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

                    System.out.println("No appliances available.");

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

                        totalMonthlyConsumption += monthlyConsumption;
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

                    System.out.println("No appliances available.");

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

                    System.out.println("No appliances available.");

                } else {

                    System.out.print(
                            "Enter current appliance wattage (W): ");
                    double currentWattage = sc.nextDouble();

                    System.out.print(
                            "Enter replacement appliance wattage (W): ");
                    double newWattage = sc.nextDouble();

                    System.out.print(
                            "Enter usage hours per day: ");
                    double hoursPerDay = sc.nextDouble();

                    double currentConsumption =
                            savingsCalculator
                                    .calculateMonthlyConsumption(
                                            currentWattage,
                                            hoursPerDay);

                    double newConsumption =
                            savingsCalculator
                                    .calculateMonthlyConsumption(
                                            newWattage,
                                            hoursPerDay);

                    double energySaving =
                            savingsCalculator.calculateMonthlySaving(
                                    currentConsumption,
                                    newConsumption);

                    double monthlyMoneySaving =
                            savingsCalculator
                                    .calculateMonthlyMoneySaving(
                                            energySaving,
                                            electricityRate);

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

            // Invalid menu choice
            else {

                System.out.println(
                        "Invalid choice. Please select 1 to 6.");
            }
        }

        // Close Scanner
        sc.close();
    }
}