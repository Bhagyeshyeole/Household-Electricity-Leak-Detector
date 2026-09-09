import java.util.ArrayList;

public class ApplianceManager {

    // Store all appliances in a list
    ArrayList<Appliance> appliances = new ArrayList<>();

    // Add a new appliance to the list
    void addAppliance(Appliance appliance) {
        appliances.add(appliance);
    }

    // Display all stored appliances
    void displayAllAppliances() {

        System.out.println("----------- APPLIANCE LIST -----------");

        // Check whether the list is empty
        if (appliances.isEmpty()) {
            System.out.println("No appliances added.");
            return;
        }

        // Display each appliance
        for (Appliance appliance : appliances) {
            appliance.displayDetails();
            System.out.println();
        }
    }

    // Return the number of stored appliances
    int getApplianceCount() {
        return appliances.size();
    }
}