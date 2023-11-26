import java.util.Scanner;

class Department {
    String deptName;
    String hodName;
    int noOfFaculty;
    int noOfStudents;
    int noOfPrograms;

    Department(String deptName, String hodName, int noOfFaculty, int noOfStudents, int noOfPrograms) {
        this.deptName = deptName;
        this.hodName = hodName;
        this.noOfFaculty = noOfFaculty;
        this.noOfStudents = noOfStudents;
        this.noOfPrograms = noOfPrograms;
    }

    void displayDetails() {
        System.out.println("Department: " + deptName);
        System.out.println("HOD: " + hodName);
        System.out.println("Faculty Count: " + noOfFaculty);
        System.out.println("Student Count: " + noOfStudents);
        System.out.println("Programs Offered: " + noOfPrograms);
    }
}

class CSEDepartment extends Department {
    CSEDepartment(String hodName, int noOfFaculty, int noOfStudents, int noOfPrograms) {
        super("CSE", hodName, noOfFaculty, noOfStudents, noOfPrograms);
    }
}

class AIDSDepartment extends Department {
    AIDSDepartment(String hodName, int noOfFaculty, int noOfStudents, int noOfPrograms) {
        super("AI&DS", hodName, noOfFaculty, noOfStudents, noOfPrograms);
    }
}

class CEDepartment extends Department {
    CEDepartment(String hodName, int noOfFaculty, int noOfStudents, int noOfPrograms) {
        super("CE", hodName, noOfFaculty, noOfStudents, noOfPrograms);
    }
}

public class ex52{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Department[] departments = new Department[3];
        departments[0] = new CSEDepartment("John", 20, 300, 5);
        departments[1] = new AIDSDepartment("Jane", 15, 250, 3);
        departments[2] = new CEDepartment("Mike", 18, 200, 4);

        int choice;
        do {
            System.out.println("1. Display All Departments");
            System.out.println("2. Display Department Details");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("List of Departments:");
                    for (Department department : departments) {
                        department.displayDetails();
                        System.out.println();
                    }
                    break;

                case 2:
                    System.out.println("Enter department number (1 for CSE, 2 for AI&DS, 3 for CE): ");
                    int deptNumber = scanner.nextInt();
                    if (deptNumber >= 1 && deptNumber <= 3) {
                        departments[deptNumber - 1].displayDetails();
                    } else {
                        System.out.println("Invalid department number.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
