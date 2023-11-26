import java.io.*;
import java.nio.file.Files;

public class bk92 {
    public static void main(String[] args) {
        try {
            // Step 1: Create and write to MyProfile.txt
            String profile = "Name: ChatGPT\nAge: Immortal\nOccupation: Virtual Assistant";
            BufferedWriter writer = new BufferedWriter(new FileWriter("mad.txt"));
            writer.write(profile);
            writer.close();

            // Step 2: Copy the file to another location
            File sourceFile = new File("mad.txt");
            File destinationFile = new File("C:\\Users\\bharath kumar\\Downloads\\mad.txt"); // Change the destination path

            if (sourceFile.exists()) {
                Files.copy(sourceFile.toPath(), destinationFile.toPath());
                System.out.println("File copied successfully to the destination.");
            } else {
                System.out.println("Source file does not exist.");
            }

            // Step 3: Delete the original file
            if (sourceFile.delete()) {
                System.out.println("Original file deleted successfully.");
            } else {
                System.out.println("Failed to delete the original file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
