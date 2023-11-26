import java.io.*;
import java.io.FileReader;
import java.io.IOException;

public class a2 {
    public static void main(String[] args) {
        try {
            int whiteSpacesCount = 0;
            int wordsCount = 0;
            int punctuationsCount = 0;

            FileReader fileReader = new FileReader("d.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {

                whiteSpacesCount += line.length() - line.replaceAll(" ", "").length();

                String[] words = line.split("  ");
                for (String word : words) {
                    if (word.matches(".*[.,!?]")) {
                        punctuationsCount++;
                    }
                }
                wordsCount += words.length;
            }

            bufferedReader.close();

            System.out.println("Number of embedded white spaces: " + whiteSpacesCount);
            System.out.println("Number of words: " + wordsCount);
            System.out.println("Number of punctuations: " + punctuationsCount);

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}