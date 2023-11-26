import java.util.Scanner;

public class EXJ_3_3{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the paragraph (press Enter twice to finish input):");
        StringBuilder paragraph = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            paragraph.append(line).append("\n");
        }

        System.out.print("Enter the word to search for: ");
        String searchWord = scanner.next();

        int count = 0;
        int index = paragraph.indexOf(searchWord);
        while (index != -1) {
            count++;
            System.out.println("Occurrence " + count + ": Position " + index);
            index = paragraph.indexOf(searchWord, index + 1);
        }

        System.out.println("The word \"" + searchWord + "\" occurred a total of " + count + " times.");
    }
}

