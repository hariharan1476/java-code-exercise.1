import java.util.Scanner;
public class EXJ_3_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the sentence (not more than 80 characters): ");
        String sentence = scanner.nextLine();
        String result = removeVowels(sentence);
        System.out.println(result);    
    }
    public static String removeVowels(String sentence) {
        return sentence.replaceAll("[AEIOUaeiou]", "*");
    }
}