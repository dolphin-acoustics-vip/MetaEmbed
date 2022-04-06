import java.util.*;

public class MetaEmbedTest {

    public static void main(String[] args) {
        runLocalEmbed();
        runFolderCounter();
    }

    /**
     * Test method made before OneDrive functionality was implemented. Takes the CSV
     * path, splits it, stores relevant information and embeds it into the CSV.
     */
    private static void runLocalEmbed() {
        Append file = new Append();
        PathFinder folder = new PathFinder();

        String path = "/Users/haroldthain/Steno/Brazil/PMC/PMC_12_A23/sel01_test.csv";
        ArrayList<String> directory = folder.readLocalPath(path);

        // Fields filled with file URL, location, species, source and encounter
        file.embed("test_data.csv", directory.get(3), directory.get(4), directory.get(5), directory.get(6));
    }

    /**
     * Test method for reading directory and printing out the name of each folder.
     */
    private static void runFolderCounter() {
        PathFinder folder = new PathFinder();
        String OneDriveURL = "https://universityofstandrews907.sharepoint.com/sites/VIPStAndrews-VIP-DolphinAcoustics/Shared%20Documents/Forms/AllItems.aspx?csf=1&web=1&e=6CuYza&cid=b466cfe3%2D555d%2D4f6e%2D9a47%2D65c2329a83d2&FolderCTID=0x01200090A5951C6349084AA884AE8D2F4A0E75&id=%2Fsites%2FVIPStAndrews%2DVIP%2DDolphinAcoustics%2FShared%20Documents%2FVIP%20%2D%20Dolphin%20Acoustics%2FMASTER%20FOLDER%2FSpecies%20Folder%2FSteno%2FBrazil%2FPMC%2FPMC%5F12%5FA23&viewid=5467bd8c%2Dc5a5%2D43d3%2Dad18%2D321431c2ce5b";

        ArrayList<String> directory = folder.readOneDrivePath(OneDriveURL);
        for (int i = 0; i < directory.size(); i++) {
            System.out.println(i + " : " + directory.get(i));
        }
        System.out.println("Number of folders in directory: " + directory.size());
    }
}
