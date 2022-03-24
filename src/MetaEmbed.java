import java.util.*;

public class MetaEmbed {
    public static void main(String[] args) {
        Append file = new Append();
        Path folder =  new Path();

        // State full path of CSV file
        String URL = "/Users/haroldthain/Brazil/Steno/PMC/PMC_12_A23/sel01_test.csv";
        ArrayList<String> directory = folder.findPath(URL);

        // Fields filled with file URL, location, species, cruise and encounter
        file.embed(URL, directory.get(3), directory.get(4), directory.get(5), directory.get(6));
    }
}
