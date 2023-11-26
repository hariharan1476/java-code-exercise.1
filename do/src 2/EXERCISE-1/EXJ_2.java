/*Write a java program that takes 3 inputs from the user and prints the greatest of
3 numbers.*/

import java.util.*;

public class EXJ_2{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        System.out.print("Enter the third number: ");
        int num3 = scanner.nextInt();

        int greatestnumber = findGreatestNumber(num1, num2, num3);

        System.out.println("The greatest number is: " + greatestnumber);

        scanner.close();
    }

    public static int findGreatestNumber(int a, int b, int c) {

        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
    }
}
