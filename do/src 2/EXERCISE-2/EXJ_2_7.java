public class EXJ_2_7 {
    public static void main(String[] args) {
        String input = "abcdab";
        char firstNonRepeated = findFirstNonRepeatedCharacter(input);

        System.out.println("The first non-repeated character is: " + firstNonRepeated);
    }

    private static char findFirstNonRepeatedCharacter(String input) {
        for (char ch : input.toCharArray()) {
            if (input.indexOf(ch) == input.lastIndexOf(ch)) {
                return ch;
            }
        }

        // Return a placeholder character if no non-repeated character is found
        return '\0';
    }
}
