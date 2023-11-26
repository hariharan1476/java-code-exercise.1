
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EXJ_3_10 {
    public static void main(String[] args) {
        String input = "Please read this application and give me gratuity";
        String result = findOccurrences(input);
        System.out.println("Sample Input: \"" + input + "\"");
        System.out.println("Sample Output: " + result);
    }

    public static String findOccurrences(String text) {
        StringBuilder occurrences = new StringBuilder();
        Pattern pattern = Pattern.compile("[aeiou]{2}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            occurrences.append(matcher.group()).append(", ");
        }

        if (occurrences.length() > 2) {
            occurrences.delete(occurrences.length() - 2, occurrences.length());
        }

        return occurrences.toString();
    }
}
