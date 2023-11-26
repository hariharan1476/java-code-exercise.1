import java.util.ArrayList;
import java.util.Scanner;

class Department {
    private String deptName;
    private String hodName;
    private int noOfFaculty;
    private int noOfStudents;
    private int noOfPrograms;

    public Department(String deptName, String hodName, int noOfFaculty, int noOfStudents, int noOfPrograms) {
        this.deptName = deptName;
        this.hodName = hodName;
        this.noOfFaculty = noOfFaculty;
        this.noOfStudents = noOfStudents;
        this.noOfPrograms = noOfPrograms;
    }

    // Getters and setters for all attributes

    public void displayDepartmentDetails() {
        System.out.println("Department Name: " + deptName);
        System.out.println("HOD Name: " + hodName);
        System.out.println("Number of Faculty: " + noOfFaculty);
        System.out.println("Number of Students: " + noOfStudents);
        System.out.println("Number of Programs: " + noOfPrograms);
    }
}

public class UniversityDepartmentApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Department> departments = new ArrayList<>();

        while (true) {
            System.out.println("University Department Information Management System");
            System.out.println("1. Add Department");
            System.out.println("2. Edit Department");
            System.out.println("3. Delete Department");
            System.out.println("4. Display Department Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    // Add Department
                    System.out.print("Enter Department Name: ");
                    String deptName = scanner.nextLine();
                    // Add code to get other department details from the user

                    // Create a Department object and add it to the ArrayList
                    departments.add(new Department(deptName, hodName, noOfFaculty, noOfStudents, noOfPrograms));
                    break;
                case 2:
                    // Edit Department
                    System.out.print("Enter Department Name to edit: ");
                    String editDeptName = scanner.nextLine();
                    // Add code to find and edit the department details
                    break;
                case 3:
                    // Delete Department
                    System.out.print("Enter Department Name to delete: ");
                    String deleteDeptName = scanner.nextLine();
                    // Add code to find and delete the department details
                    break;
                case 4:
                    // Display Department Details
                    System.out.print("Enter Department Name to display details: ");
                    String displayDeptName = scanner.nextLine();
                    // Add code to find and display the department details
                    break;
                case 5:
                    // Exit the program
                    System.out.println("Exiting the University Department Information Management System.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
