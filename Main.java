public class Main {

    public static void main(String[] args) {

        // Create appliance manager
        ApplianceManager manager =
                new ApplianceManager();

        // Add appliances
        manager.addAppliance(
                new Appliance("Fan", 75, 8));

        manager.addAppliance(
                new Appliance("Refrigerator", 150, 10));

        manager.addAppliance(
                new Appliance("Air Conditioner", 1500, 5));

        // Create analyzer
        ConsumptionAnalyzer analyzer =
                new ConsumptionAnalyzer();

        System.out.println("===== CONSUMPTION ANALYSIS =====\n");

        // Analyze every appliance
        for (Appliance appliance : manager.getAppliances()) {
            analyzer.analyzeAppliance(appliance);
        }
    }
}