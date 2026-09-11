import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileManager {

    // Location of the CSV file
    private static final String FILE_NAME = "data/appliances.csv";

    // Save all appliances to CSV
    public void saveAppliances(ArrayList<Appliance> appliances) {

        try (PrintWriter writer = new PrintWriter(
                new FileWriter(FILE_NAME))) {

            // Write CSV header
            writer.println("name,wattage,hoursPerDay");

            // Write each appliance
            for (Appliance appliance : appliances) {

                writer.println(
                        appliance.name + ","
                        + appliance.wattage + ","
                        + appliance.hoursPerDay);
            }

        } catch (IOException e) {

            System.out.println("Error saving appliances.");
        }
    }

    // Load appliances from CSV
    public ArrayList<Appliance> loadAppliances() {

        ArrayList<Appliance> appliances = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            // Read and skip the header
            String line = reader.readLine();

            // Read remaining lines
            while ((line = reader.readLine()) != null) {

                // Ignore empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                // Split the CSV line
                String[] data = line.split(",");

                // Check that the row has all 3 values
                if (data.length != 3) {
                    System.out.println(
                            "Skipping invalid CSV row: " + line);
                    continue;
                }

                try {

                    String name = data[0].trim();
                    double wattage =
                            Double.parseDouble(data[1].trim());
                    double hoursPerDay =
                            Double.parseDouble(data[2].trim());

                    // Create appliance object
                    Appliance appliance =
                            new Appliance(
                                    name,
                                    wattage,
                                    hoursPerDay);

                    // Add appliance to list
                    appliances.add(appliance);

                } catch (NumberFormatException e) {

                    // Skip rows with invalid numbers
                    System.out.println(
                            "Skipping invalid CSV data: " + line);
                }
            }

        } catch (IOException e) {

            // File does not exist yet
        }

        return appliances;
    }
}