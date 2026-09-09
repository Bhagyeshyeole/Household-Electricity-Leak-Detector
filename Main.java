public class Main {

    public static void main(String[] args) {

        // Create appliance objects
        Appliance fan = new Appliance("Fan", 75, 8);

        // Create calculation objects
        ElectricityCalculator electricityCalculator =
                new ElectricityCalculator();

        BillCalculator billCalculator =
                new BillCalculator();

        // Calculate daily consumption
        double dailyConsumption =
                electricityCalculator.calculateDailyConsumption(
                        fan.wattage, fan.hoursPerDay);

        // Calculate monthly consumption
        double monthlyConsumption =
                electricityCalculator.calculateMonthlyConsumption(
                        dailyConsumption);

        // Electricity rate
        double electricityRate = 7;

        // Calculate monthly bill
        double monthlyBill =
                billCalculator.calculateMonthlyBill(
                        monthlyConsumption, electricityRate);

        // Display results
        System.out.println("----------- RESULT -----------");
        System.out.println("Appliance: " + fan.name);
        System.out.printf("Daily Consumption: %.2f kWh%n",
                dailyConsumption);
        System.out.printf("Monthly Consumption: %.2f kWh%n",
                monthlyConsumption);
        System.out.printf("Electricity Rate: ₹%.2f per unit%n",
                electricityRate);
        System.out.printf("Estimated Monthly Bill: ₹%.2f%n",
                monthlyBill);
    }
}