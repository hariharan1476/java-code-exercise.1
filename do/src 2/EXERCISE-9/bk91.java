import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bk91 {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\bharath kumar\\Downloads\\Madhu.txt"; // Provide the path to your text file

        try {
            // Read the content of the file
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder text = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }

            // Close the file reader
            reader.close();

            // Call the function to count spaces, words, and punctuation
            countSpacesWordsPunctuation(text.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void countSpacesWordsPunctuation(String text) {
        // Count spaces
        int spaceCount = text.length() - text.replaceAll(" ", "").length();

        // Count words using regular expressions
        String[] words = text.split("\\s+");
        int wordCount = words.length;

        // Count punctuation using regular expressions
        Pattern punctuationPattern = Pattern.compile("[\\p{Punct}]");
        Matcher punctuationMatcher = punctuationPattern.matcher(text);
        int punctuationCount = 0;

        while (punctuationMatcher.find()) {
            punctuationCount++;
        }

        // Output the counts
        System.out.println("Number of embedded white spaces: " + spaceCount);
        System.out.println("Number of words: " + wordCount);
        System.out.println("Number of punctuations: " + punctuationCount);
    }
}
