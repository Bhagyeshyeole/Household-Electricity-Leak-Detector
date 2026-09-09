import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Create a list to store appliances
        ArrayList<Appliance> appliances = new ArrayList<>();

        // Create appliance objects
        Appliance fan = new Appliance("Fan", 75, 8);
        Appliance bulb = new Appliance("LED Bulb", 10, 6);
        Appliance tv = new Appliance("TV", 100, 5);

        // Add appliances to the list
        appliances.add(fan);
        appliances.add(bulb);
        appliances.add(tv);

        // Display total number of appliances
        System.out.println("Total Appliances: " + appliances.size());

        System.out.println("\n----------- APPLIANCE LIST -----------");

        // Display every appliance in the list
        for (Appliance appliance : appliances) {
            appliance.displayDetails();
            System.out.println();
        }
    }
}