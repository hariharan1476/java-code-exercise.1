import java.util.*;

public class EXJ_2_6{

    private static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

    private static void displayAnagrams(String[] arr) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String word : arr) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            if (!anagramGroups.containsKey(sortedWord)) {
                anagramGroups.put(sortedWord, new ArrayList<>());
            }

            anagramGroups.get(sortedWord).add(word);
        }

        for (List<String> anagrams : anagramGroups.values()) {
            if (anagrams.size() > 1) {
                System.out.println("Anagrams: " + anagrams);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of words in the array: ");
        int n = scanner.nextInt();

        String[] wordArray = new String[n];
        System.out.println("Enter " + n + " words:");

        for (int i = 0; i < n; i++) {
            wordArray[i] = scanner.next();
        }

        System.out.println("Anagrams in the given array are:");
        displayAnagrams(wordArray);

        scanner.close();
    }
}
