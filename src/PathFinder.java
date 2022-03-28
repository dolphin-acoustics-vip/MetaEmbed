import java.io.*;
import java.util.*;

public class PathFinder {
    
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

    /**
     * Splits the provided URL so that only location, species, cruise and encounter
     * information remains. Stores this in a list so it can be accessed elsewhere.
     * 
     * @param URL - OneDrive URL of folder containing the CSV
     * @return list with relevant folder informaton.
     */
    public ArrayList<String> readOneDrivePath(String URL) {
        ArrayList<String> folderList = new ArrayList<>();

        String trimmedURL = URL.split("Species%20%28Master%20Folder%29")[1];
        trimmedURL = trimmedURL.split("&listurl")[0];
        //trimmedURL.replace("target", replacement);
        //System.out.println(trimmedURL);

        String[] directory = trimmedURL.split("%2F");

        for (String folder : directory) {
            folderList.add(folder);
        }

        return folderList;
    }
}
