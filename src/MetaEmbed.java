import java.util.*;

public class MetaEmbed {
    public static void main(String[] args) {
        EmbedCruise("test_data.csv",
                "https://universityofstandrews907.sharepoint.com/sites/VIPStAndrews-VIP-DolphinAcoustics/Shared%20Documents/Forms/AllItems.aspx?csf=1&web=1&e=6CuYza&cid=b466cfe3%2D555d%2D4f6e%2D9a47%2D65c2329a83d2&FolderCTID=0x01200090A5951C6349084AA884AE8D2F4A0E75&id=%2Fsites%2FVIPStAndrews%2DVIP%2DDolphinAcoustics%2FShared%20Documents%2FVIP%20%2D%20Dolphin%20Acoustics%2FMASTER%20FOLDER%2FSpecies%20Folder%2FSteno%2FBrazil%2FPMC%2FPMC%5F12%5FA23&viewid=5467bd8c%2Dc5a5%2D43d3%2Dad18%2D321431c2ce5b");

        //EmbedDatabase("test_data.csv",
                //"https://universityofstandrews907.sharepoint.com/sites/VIPStAndrews-VIP-DolphinAcoustics/Shared%20Documents/Forms/AllItems.aspx?csf=1&web=1&e=6CuYza&cid=b466cfe3%2D555d%2D4f6e%2D9a47%2D65c2329a83d2&FolderCTID=0x01200090A5951C6349084AA884AE8D2F4A0E75&id=%2Fsites%2FVIPStAndrews%2DVIP%2DDolphinAcoustics%2FShared%20Documents%2FVIP%20%2D%20Dolphin%20Acoustics%2FMASTER%20FOLDER%2FSpecies%20Folder%2FSteno%2FMalta%2DSicily%2FWatkins%20Database%2FMalta%2F85014&viewid=5467bd8c%2Dc5a5%2D43d3%2Dad18%2D321431c2ce5b");
    }

    /**
     * Assembles folder list and calls the embed method to embed location, species,
     * source and encounter information (which is contained within the OneDrive URL)
     * into the provided CSV file.
     * 
     * @param localPath   - path of downloaded CSV file
     * @param OneDriveURL - folder in OneDrive where the CSV file is stored
     */
    private static void EmbedCruise(String localPath, String OneDriveURL) {
        Append file = new Append();
        PathFinder folder = new PathFinder();

        ArrayList<String> directory = folder.readOneDrivePath(OneDriveURL);
        file.embed(localPath, directory.get(0), directory.get(1), directory.get(2), directory.get(3));
    }

    /**
     * Similar to above method, assembles folder list and embeds information into
     * the CSV file. This method is specifically for the Watkins Database which has
     * different folder structure to other sources.
     * 
     * @param localPath
     * @param OneDriveURL
     */
    private static void EmbedDatabase(String localPath, String OneDriveURL) {
        Append file = new Append();
        PathFinder folder = new PathFinder();

        ArrayList<String> directory = folder.readOneDrivePath(OneDriveURL);
        file.embed(localPath, directory.get(0), directory.get(3), directory.get(2), directory.get(4));
    }
}
