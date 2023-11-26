import java.util.Scanner;

public class EXJ_3_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the paragraph (press Enter twice to finish input):");
        StringBuilder paragraph = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            paragraph.append(line).append("\n");
        }

        int spaces = countSpaces(paragraph.toString());
        int words = countWords(paragraph.toString());
        int characters = countCharacters(paragraph.toString());
        int lines = countLines(paragraph.toString());

        System.out.println("Number of spaces: " + spaces);
        System.out.println("Number of words: " + words);
        System.out.println("Number of characters: " + characters);
        System.out.println("Number of lines: " + lines);
    }

    private static int countSpaces(String text) {
        return text.length() - text.replace(" ", "").length();
    }

    private static int countWords(String text) {
        String[] words = text.trim().split("\\s+");
        return words.length;
    }
    private static int countCharacters(String text) {
        return text.length();
    }

    private static int countLines(String text) {
        String[] lines = text.split("\r\n|\r|\n");
        return lines.length;
    }
}
