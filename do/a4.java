import java.io.*;


public class a4 {
    public static void main(String[] args) {
        String firstFilePath = "/Users/soorya/Desktop/1st.txt";
        String secondFilePath = "/Users/soorya/Desktop/2nd.txt";
        String finalFilePath = "/Users/soorya/Desktop/final.txt";

        c(firstFilePath, secondFilePath, finalFilePath);
    }

    private static void c(String firstFilePath, String secondFilePath, String finalFilePath) {
        try {
            BufferedReader reader1 = new BufferedReader(new FileReader(firstFilePath));
            BufferedReader reader2 = new BufferedReader(new FileReader(secondFilePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(finalFilePath));

            String line;

            // Copy content from the first file
            while ((line = reader1.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            // Add a separator between the content of the two files
            writer.write("==MERGE_SEPARATOR==");
            writer.newLine();

            // Copy content from the second file
            while ((line = reader2.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Files merged successfully. Merged content saved in: " + finalFilePath);

            // Close the resources
            reader1.close();
            reader2.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}