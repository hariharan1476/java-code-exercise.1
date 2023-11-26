import java.util.Scanner;

public class GreatestOfThreeNumbers {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter three numbers
        System.out.print("Enter the first number: ");
        double number1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double number2 = scanner.nextDouble();

        System.out.print("Enter the third number: ");
        double number3 = scanner.nextDouble();

        // Close the Scanner to free up resources
        scanner.close();

        // Find the greatest number among the three
    double greatest = Math.max(number1, Math.max(number2,number3));

        // Print the greatest number
        System.out.println("The greatest number is: " + greatest);
    }
}
