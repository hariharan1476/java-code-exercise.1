import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int empId;
    private String name;
    private String department;
    private String designation;
    private int experience;
    private double basicPay;
    private double DA;
    private double gradePay;
    private double personalPay;
    private double incomeTax;
    private double professionalTax;
    private double epf;

    public Employee(int empId, String name, String department, String designation, int experience, double basicPay, double DA, double gradePay, double personalPay, double incomeTax, double professionalTax, double epf) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.experience = experience;
        this.basicPay = basicPay;
        this.DA = DA;
        this.gradePay = gradePay;
        this.personalPay = personalPay;
        this.incomeTax = incomeTax;
        this.professionalTax = professionalTax;
        this.epf = epf;
    }

    // Getters and setters for all attributes

    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Designation: " + designation);
        System.out.println("Experience: " + experience + " years");
        System.out.println("Basic Pay: " + basicPay);
        System.out.println("DA: " + DA);
        System.out.println("Grade Pay: " + gradePay);
        System.out.println("Personal Pay: " + personalPay);
        System.out.println("Income Tax: " + incomeTax);
        System.out.println("Professional Tax: " + professionalTax);
        System.out.println("EPF: " + epf);
    }
}

public class EmployeePayrollApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        while (true) {
            System.out.println("Employee Payroll Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Edit Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Display Employee Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    // Add Employee
                    System.out.print("Enter Employee ID: ");
                    int empId = scanner.nextInt();
                    scanner.nextLine();
                    // Add code to get other employee details from the user

                    // Create an Employee object and add it to the ArrayList
                    employees.add(new Employee(empId, name, department, designation, experience, basicPay, DA, gradePay, personalPay, incomeTax, professionalTax, epf));
                    break;
                case 2:
                    // Edit Employee
                    System.out.print("Enter Employee ID to edit: ");
                    int editEmpId = scanner.nextInt();
                    scanner.nextLine();
                    // Add code to find and edit the employee details
                    break;
                case 3:
                    // Delete Employee
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteEmpId = scanner.nextInt();
                    scanner.nextLine();
                    // Add code to find and delete the employee details
                    break;
                case 4:
                    // Display Employee Details
                    System.out.print("Enter Employee ID to display details: ");
                    int displayEmpId = scanner.nextInt();
                    scanner.nextLine();
                    // Add code to find and display the employee details
                    break;
                case 5:
                    // Exit the program
                    System.out.println("Exiting the Employee Payroll Management System.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
