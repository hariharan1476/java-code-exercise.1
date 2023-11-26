import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class EXJ_3_8{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();

        String result = removeDuplicates(str1, str2);
        System.out.println("Modified string: " + result);
    }

    public static String removeDuplicates(String str1, String str2) {
        Set<Character> charSet = new HashSet<>();
        for (char c : str2.toCharArray()) {
            charSet.add(c);
        }

        StringBuilder result = new StringBuilder();
        for (char c : str1.toCharArray()) {
            if (!charSet.contains(c)) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
