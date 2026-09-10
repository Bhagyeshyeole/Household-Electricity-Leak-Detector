import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileManager {

    // Location of the CSV file
    private static final String FILE_NAME = "data/appliances.csv";

    // Save all appliances to the CSV file
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

    // Load appliances from the CSV file
    public ArrayList<Appliance> loadAppliances() {

        ArrayList<Appliance> appliances = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            // Skip CSV header
            reader.readLine();

            String line;

            // Read each row
            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                String name = data[0];
                double wattage = Double.parseDouble(data[1]);
                double hoursPerDay = Double.parseDouble(data[2]);

                Appliance appliance =
                        new Appliance(name, wattage, hoursPerDay);

                appliances.add(appliance);
            }

        } catch (IOException e) {

            // File may not exist on first run
        }

        return appliances;
    }
}