import java.util.Scanner;
public class EXJ_3_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the sentence (not more than 80 characters): ");
        String sentence = scanner.nextLine();
        String result = removeVowels(sentence);
        System.out.println("Sentence without vowels: " + result);    
    }
    public static String removeVowels(String sentence) {
        return sentence.replaceAll("[AEIOUaeiou]", "");
    }
}