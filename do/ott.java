import java.util.Scanner;

public class ott {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double basicPrice = 499.0;
        double kidsPrice = 200.0;
        double sportsPrice = 700.0;
        double englishPrice = 300.0;

        boolean exit = false;

        while (!exit) {
            System.out.println("\n**** OTT Platform Subscription Menu ****");
            System.out.println("1. Basics - $499");
            System.out.println("2. Kids - $200 + Basics");
            System.out.println("3. Sports - $700 + Basics");
            System.out.println("4. English - $300 + Basics");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You have subscribed to Basics. Price: $" + basicPrice);
                    break;
                case 2:
                    System.out.println("You have subscribed to Kids. Price: $" + (kidsPrice + basicPrice));
                    break;
                case 3:
                    System.out.println("You have subscribed to Sports. Price: $" + (sportsPrice + basicPrice));
                    break;
                case 4:
                    System.out.println("You have subscribed to English. Price: $" + (englishPrice + basicPrice));
                    break;
                case 5:
                    System.out.println("Thank you for using the OTT Platform. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
        input.close();
    }
}