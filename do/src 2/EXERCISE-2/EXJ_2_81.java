public class EXJ_2_81 {
    public static void main(String[] args) {
        String input = "hello world";
        countVowelsAndConsonants(input);
    }

    public static void countVowelsAndConsonants(String str) {
        int vowels = 0;
        int consonants = 0;

        str = str.toLowerCase(); // Convert to lowercase for case-insensitive count

        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Number of vowels: " + vowels);
        System.out.println("Number of consonants: " + consonants);
    }
}
