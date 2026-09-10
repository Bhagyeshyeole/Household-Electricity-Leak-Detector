public class SavingsCalculator {

    // Calculate monthly consumption of an appliance
    public double calculateMonthlyConsumption(
            double wattage, double hoursPerDay) {

        return (wattage * hoursPerDay / 1000) * 30;
    }

    // Calculate electricity units saved per month
    public double calculateMonthlySaving(
            double currentConsumption,
            double newConsumption) {

        return currentConsumption - newConsumption;
    }

    // Calculate money saved per month
    public double calculateMonthlyMoneySaving(
            double energySaving,
            double electricityRate) {

        return energySaving * electricityRate;
    }

    // Calculate money saved per year
    public double calculateAnnualMoneySaving(
            double monthlyMoneySaving) {

        return monthlyMoneySaving * 12;
    }
}