public class ConsumptionAnalyzer {

    // Analyze monthly consumption of one appliance
    public void analyzeAppliance(Appliance appliance) {

        // Calculate daily consumption
        double dailyConsumption =
                (appliance.wattage * appliance.hoursPerDay) / 1000;

        // Calculate monthly consumption
        double monthlyConsumption = dailyConsumption * 30;

        System.out.println("Appliance: " + appliance.name);
        System.out.printf("Monthly Consumption: %.2f kWh%n",
                monthlyConsumption);

        // Classify the consumption
        if (monthlyConsumption <= 50) {

            System.out.println("Status: Normal Consumption");

        } else if (monthlyConsumption <= 100) {

            System.out.println("Status: Moderate Consumption");

        } else {

            System.out.println("Status: High Consumption");
        }

        System.out.println();
    }
}