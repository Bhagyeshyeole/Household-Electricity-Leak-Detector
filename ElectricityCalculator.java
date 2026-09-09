public class ElectricityCalculator {

    // Calculate daily electricity consumption in kWh
    public double calculateDailyConsumption(double wattage, double hoursPerDay) {
        return (wattage * hoursPerDay) / 1000;
    }

    // Calculate monthly electricity consumption
    public double calculateMonthlyConsumption(double dailyConsumption) {
        return dailyConsumption * 30;
    }
}