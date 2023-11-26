import java.util.ArrayList;
import java.util.Scanner;

class Smartphone {
    private String productName;
    private String operatingSystem;
    private double displaySize;
    private int memory;

    public Smartphone(String productName, String operatingSystem, double displaySize, int memory) {
        this.productName = productName;
        this.operatingSystem = operatingSystem;
        this.displaySize = displaySize;
        this.memory = memory;
    }

    // Getters and setters for all attributes

    public void displaySmartphoneDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Operating System: " + operatingSystem);
        System.out.println("Display Size: " + displaySize + " inches");
        System.out.println("Memory: " + memory + " GB");
    }
}

public class SmartphoneSpecsApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Smartphone> smartphones = new ArrayList<>();

        while (true) {
            System.out.println("Smartphone Technical Specifications Management System");
            System.out.println("1. Add Smartphone");
            System.out.println("2. Edit Smartphone");
            System.out.println("3. Delete Smartphone");
            System.out.println("4. Display Smartphone Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    // Add Smartphone
                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine();
                    // Add code to get other smartphone details from the user

                    // Create a Smartphone object and add it to the ArrayList
                    smartphones.add(new Smartphone(productName, operatingSystem, displaySize, memory));
                    break;
                case 2:
                    // Edit Smartphone
                    System.out.print("Enter Product Name to edit: ");
                    String editProductName = scanner.nextLine();
                    // Add code to find and edit the smartphone details
                    break;
                case 3:
                    // Delete Smartphone
                    System.out.print("Enter Product Name to delete: ");
                    String deleteProductName = scanner.nextLine();
                    // Add code to find and delete the smartphone details
                    break;
                case 4:
                    // Display Smartphone Details
                    System.out.print("Enter Product Name to display details: ");
                    String displayProductName = scanner.nextLine();
                    // Add code to find and display the smartphone details
                    break;
                case 5:
                    // Exit the program
                    System.out.println("Exiting the Smartphone Technical Specifications Management System.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
