import java.util.*;

public class MetaEmbed {
    public static void main(String[] args) {
        EmbedOneDrive("test_data.csv", "https://universityofstandrews907-my.sharepoint.com/personal/ht51_st-andrews_ac_uk/_layouts/15/onedrive.aspx?id=%2Fsites%2FDolphinAcousticsVIP2%2FShared%20Documents%2FGeneral%2FConcept%20Folder%2FSpecies%20%28Master%20Folder%29%2FBrazil%2FSteno%2FPMC%20source%20%28unknown%29%2FPMC%5F12%5FA23&listurl=https%3A%2F%2Funiversityofstandrews907%2Esharepoint%2Ecom%2Fsites%2FDolphinAcousticsVIP2%2FShared%20Documents&viewid=bc200e1a%2D1826%2D49f8%2Dab05%2D406e393a1e96");
    }

    /**
     * Assembles folder list and calls the embed method to embed location, species,
     * cruise and encounter information (which is contained within the OneDrive URL)
     * into the provided CSV file.
     * 
     * @param localPath   - path of downloaded CSV file
     * @param OneDriveURL - folder in OneDrive where the CSV file is stored
     */
    public static void EmbedOneDrive(String localPath, String OneDriveURL) {
        Append file = new Append();
        PathFinder folder = new PathFinder();

        ArrayList<String> directory = folder.readOneDrivePath(OneDriveURL);
        file.embed(localPath, directory.get(1), directory.get(2), directory.get(3), directory.get(4));
    }

    /**
     * Test method made before OneDrive functionality was implemented. Takes the CSV
     * path, splits it, stores relevant information and embeds it into the CSV.
     */
    public static void EmbedLocal() {
        Append file = new Append();
        PathFinder folder = new PathFinder();

        String path = "/Users/haroldthain/Brazil/Steno/PMC/PMC_12_A23/sel01_test.csv";
        ArrayList<String> directory = folder.readLocalPath(path);

        // Fields filled with file URL, location, species, cruise and encounter
        file.embed(path, directory.get(3), directory.get(4), directory.get(5), directory.get(6));
    }

}
