
public class Appliance {

    // Store appliance name
    String name;

    // Store appliance wattage
    double wattage;

    // Store daily usage hours
    double hoursPerDay;

    // Constructor to create an appliance
    Appliance(String name, double wattage, double hoursPerDay) {
        this.name = name;
        this.wattage = wattage;
        this.hoursPerDay = hoursPerDay;
    }

    // Display appliance information
    void displayDetails() {
        System.out.println("Appliance Name: " + name);
        System.out.println("Wattage: " + wattage + " W");
        System.out.println("Usage Hours Per Day: " + hoursPerDay);
    }
}