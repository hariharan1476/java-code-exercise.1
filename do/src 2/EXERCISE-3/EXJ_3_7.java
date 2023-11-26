import java.util.Scanner;

public class EXJ_3_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String result = input.toUpperCase();
        System.out.println("Modified string: " + result);
    }

}
