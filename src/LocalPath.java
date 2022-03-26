import java.io.*;
import java.util.*;

public class LocalPath {

    /**
     * Takes the path of the CSV file and stores its folder names in a list.
     * 
     * @param filename - name of file
     * @return list containing each folder within which the specified file resides.
     */
    public ArrayList<String> findPath(String filename) {
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
