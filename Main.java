public class Main {

    public static void main(String[] args) {

        // Create an appliance manager
        ApplianceManager manager = new ApplianceManager();

        // Create appliance objects
        Appliance fan = new Appliance("Fan", 75, 8);
        Appliance bulb = new Appliance("LED Bulb", 10, 6);
        Appliance tv = new Appliance("TV", 100, 5);

        // Add appliances using the manager
        manager.addAppliance(fan);
        manager.addAppliance(bulb);
        manager.addAppliance(tv);

        // Display number of appliances
        System.out.println("Total Appliances: "
                + manager.getApplianceCount());

        // Display all appliances
        manager.displayAllAppliances();
    }
}