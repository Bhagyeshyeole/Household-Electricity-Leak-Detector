public class BillCalculator {

    // Calculate estimated monthly electricity bill
    public double calculateMonthlyBill(double monthlyConsumption,
                                       double electricityRate) {
        return monthlyConsumption * electricityRate;
    }
}