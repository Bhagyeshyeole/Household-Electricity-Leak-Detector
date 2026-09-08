import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("=================================");
            System.out.println("  HOUSEHOLD ELECTRICITY");
            System.out.println("       LEAK DETECTOR");
            System.out.println("=================================");
            
            System.out.print("Enter appliance name: ");
            String applianceName = sc.nextLine();
            
            System.out.print("Enter wattage (W): ");
            double wattage = sc.nextDouble();
            
            System.out.print("Enter usage hours per day: ");
            double hoursPerDay = sc.nextDouble();
            
            System.out.print("Enter electricity rate per unit (₹): ");
            double electricityRate = sc.nextDouble();
            
            // Calculate daily electricity consumption
            double dailyConsumption = (wattage * hoursPerDay) / 1000;
            
            // Calculate monthly electricity consumption
            double monthlyConsumption = dailyConsumption * 30;
            
            // Calculate monthly electricity bill
            double monthlyBill = monthlyConsumption * electricityRate;
            
            System.out.println("\n----------- RESULT -----------");
            System.out.println("Appliance: " + applianceName);
            System.out.printf("Daily Consumption: %.2f kWh%n", dailyConsumption);
            System.out.printf("Monthly Consumption: %.2f kWh%n", monthlyConsumption);
            System.out.printf("Electricity Rate: ₹%.2f per unit%n", electricityRate);
            System.out.printf("Estimated Monthly Bill: ₹%.2f%n", monthlyBill);
        }
    }
}