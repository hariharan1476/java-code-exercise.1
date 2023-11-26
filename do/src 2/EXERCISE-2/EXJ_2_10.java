public class EXJ_2_10 {
    public static void main(String[] args) {
        char[] charArray = {'a', 'b', 'c', 'a', 'd', 'a'};
        char targetChar = 'a';
        
        int count = countCharacterOccurrences(charArray, targetChar);
        System.out.println("The character '" + targetChar + "' appears " + count + " times in the array.");
    }

    public static int countCharacterOccurrences(char[] charArray, char targetChar) {
        int count = 0;
        for (char c : charArray) {
            if (c == targetChar) {
                count++;
            }
        }
        return count;
    }
}

