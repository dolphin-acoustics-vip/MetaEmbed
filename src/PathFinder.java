import java.io.*;
import java.util.*;

public class PathFinder {

    /**
     * Splits the provided URL so that only location, species, source and encounter
     * information remains. Stores this in a list so it can be accessed elsewhere.
     * 
     * @param URL - OneDrive URL of folder containing the CSV
     * @return list with relevant folder informaton.
     */
    public ArrayList<String> readOneDrivePath(String URL) {
        ArrayList<String> folderList = new ArrayList<>();

        String trimmedURL = URL.split("MASTER%20FOLDER%2FSpecies%20Folder%2F")[1];
        trimmedURL = trimmedURL.split("&viewid")[0];

        String[] directory = trimmedURL.split("%2F");

        for (String folder : directory) {

            if (folder.contains("%5F")) {
                String newFolder = folder.replace("%5F", "_");
                folderList.add(newFolder);
            
            } else if (folder.contains("%20")) {
                String newFolder = folder.replace("%20", " ");
                folderList.add(newFolder);

            } else {
                folderList.add(folder);
            }
        }

        return folderList;
    }

    /**
     * Takes the path of the CSV file and stores its folder names in a list.
     * 
     * @param filename - name of file
     * @return list containing each folder within which the specified file resides.
     */
    public ArrayList<String> readLocalPath(String filename) {
        ArrayList<String> folderList = new ArrayList<>();

        File file = new File(filename);
        String absolute = file.getAbsolutePath();
        System.out.println(absolute);

        String[] directory = absolute.split("/");
        for (String folder : directory) {

            if (!folder.contains(filename)) {
                folderList.add(folder);
            }
        }
        return folderList;
    }
}
