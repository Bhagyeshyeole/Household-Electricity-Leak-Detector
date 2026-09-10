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

        System.out.println("\n----------- APPLIANCE LIST -----------");

        // Check if there are no appliances
        if (appliances.isEmpty()) {
            System.out.println("No appliances added.");
            return;
        }

        // Display each appliance with a number
        for (int i = 0; i < appliances.size(); i++) {

            System.out.println("\nAppliance " + (i + 1));

            appliances.get(i).displayDetails();
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