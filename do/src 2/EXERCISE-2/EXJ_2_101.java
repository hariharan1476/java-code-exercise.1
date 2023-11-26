import java.util.HashMap;
import java.util.Map;

public class EXJ_2_101 {
    public static void main(String[] args) {
        char[] charArray = {'a', 'b', 'c', 'a', 'd', 'a'};
        
        char highestOccurredChar = findHighestOccurredCharacter(charArray);
        System.out.println("The highest occurred character in the array is: " + highestOccurredChar);
    }

    public static char findHighestOccurredCharacter(char[] charArray) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char c : charArray) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        char highestOccurredChar = ' ';
        int maxCount = 0;

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                highestOccurredChar = entry.getKey();
            }
        }

        return highestOccurredChar;
    }
}
