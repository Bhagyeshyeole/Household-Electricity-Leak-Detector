import java.util.ArrayList;

public class ApplianceManager {

    // Store all appliances
    ArrayList<Appliance> appliances = new ArrayList<>();

    // Add an appliance
    void addAppliance(Appliance appliance) {
        appliances.add(appliance);
    }

    // Display all appliances
    void displayAllAppliances() {

        System.out.println("----------- APPLIANCE LIST -----------");

        // Check if there are no appliances
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

    // Return number of appliances
    int getApplianceCount() {
        return appliances.size();
    }

    // Return the appliance list
    ArrayList<Appliance> getAppliances() {
        return appliances;
    }
}