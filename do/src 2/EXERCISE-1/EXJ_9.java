/*Write a menu driven program in Java to accept a number and perform the
following operations depending on the user's choice:
 Entered number is a Buzz number or not.
 Entered number is even or odd.
 Entered number is positive or negative.*/

import java.util.*;

public class EXJ_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. Check if the number is a Buzz number");
            System.out.println("2. Check if the number is even or odd");
            System.out.println("3. Check if the number is positive or negative");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            System.out.print("Enter a number: ");
            int number = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (isBuzzNumber(number)) {
                        System.out.println(number + " is a Buzz number.");
                    } else {
                        System.out.println(number + " is not a Buzz number.");
                    }
                    break;
                case 2:
                    if (isEven(number)) {
                        System.out.println(number + " is an even number.");
                    } else {
                        System.out.println(number + " is an odd number.");
                    }
                    break;
                case 3:
                    if (isPositive(number)) {
                        System.out.println(number + " is a positive number.");
                    } else {
                        System.out.println(number + " is a negative number.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } 
        while (choice != 0);
        scanner.close();
    }

    public static boolean isBuzzNumber(int number) {
        return number % 7 == 0 || number % 10 == 7;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isPositive(int number) {
        return number >= 0;
    }
}

