import java.util.*;

public class OneDrivePath {

    /**
     * Splits the provided URL so that only location, species, cruise and encounter
     * information remains. Stores this in a list so it can be accessed elsewhere.
     * 
     * @param URL - OneDrive URL of folder containing the CSV
     * @return list with relevant folder informaton.
     */
    public ArrayList<String> readURL(String URL) {
        ArrayList<String> folderList = new ArrayList<>();

        String trimmedURL = URL.split("Species%20%28Master%20Folder%29")[1];
        trimmedURL = trimmedURL.split("&listurl")[0];
        //System.out.println(trimmedURL);

        String[] directory = trimmedURL.split("%2F");

        for (String folder : directory) {
            folderList.add(folder);
        }

        return folderList;
    }
}
