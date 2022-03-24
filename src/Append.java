import java.io.*;
import java.util.*;

public class Append {

    private static List<List<String>> records = new ArrayList<>();
    private static final String COMMA_DELIMITER = ",";

    /**
     * Overwrites the CSV file so that metadata comments are at the top of the new
     * CSV. Method then loops through the records list and appends each line to
     * the new CSV.
     * 
     * @param file      - absolute file path
     * @param location  - location of the encounter
     * @param species   - dolphin species
     * @param cruise    - cruise that collected the data
     * @param encounter - name/code of the encounter
     */
    public void embed(String file, String location, String species, String cruise, String encounter) {
        readToArray(file);

        try {
            FileWriter writer = new FileWriter(file);
            writer.append("#Location," + location);
            writer.append("\n" + "#Species," + species);
            writer.append("\n" + "#Cruise," + cruise);
            writer.append("\n" + "#Encounter," + encounter + "\n");

            for (List<String> list : records) {
                for (String string : list) {
                    writer.append(string + ",");
                }
                writer.append("\n");
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads a CSV file, deliminates it and stores each line in an list.
     * 
     * @param file - abolute file path
     */
    private void readToArray(String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}