public class InputValidator {

    // Check whether appliance name is not empty
    public boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    // Check whether wattage is positive
    public boolean isValidWattage(double wattage) {
        return wattage > 0;
    }

    // Check whether usage is between 0 and 24 hours
    public boolean isValidHours(double hoursPerDay) {
        return hoursPerDay > 0 && hoursPerDay <= 24;
    }

    // Check whether menu choice is between 1 and 6
    public boolean isValidMenuChoice(int choice) {
        return choice >= 1 && choice <= 6;
    }

    // Check whether electricity rate is positive
    public boolean isValidRate(double rate) {
        return rate > 0;
    }
}