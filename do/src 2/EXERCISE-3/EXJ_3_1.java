import java.util.Scanner;

public class EXJ_3_1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sequences = new String[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Sequence " + (i + 1) + ": ");
            sequences[i] = scanner.next();
        }

        System.out.print("Enter the character to search for: ");
        char searchChar = scanner.next().charAt(0);

        int maxOccurrences = 0;
        for (String sequence : sequences) {
            int count = countOccurrences(sequence, searchChar);
            maxOccurrences = Math.max(maxOccurrences, count);
        }

        System.out.println("Character " + searchChar + " occurred a maximum of " + maxOccurrences + " times");
    }

    private static int countOccurrences(String str, char target) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == target) {
                count++;
            }
        }
        return count;
    }
}
