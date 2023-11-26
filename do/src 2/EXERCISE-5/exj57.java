import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int registerNo;
    String department;
    float cgpa;
    String hostelName;
    String mentorName;
    int noOfArrears;

    Student(String name, int registerNo, String department, float cgpa, String hostelName, String mentorName, int noOfArrears) {
        this.name = name;
        this.registerNo = registerNo;
        this.department = department;
        this.cgpa = cgpa;
        this.hostelName = hostelName;
        this.mentorName = mentorName;
        this.noOfArrears = noOfArrears;
    }

    void displayStudentDetails() {
        System.out.println("Name: " + name);
        System.out.println("Register No: " + registerNo);
        System.out.println("Department: " + department);
        System.out.println("CGPA: " + cgpa);
        System.out.println("Hostel Name: " + hostelName);
        System.out.println("Mentor Name: " + mentorName);
        System.out.println("No. of Arrears: " + noOfArrears);
    }
}

class PGStudent extends Student {
    String specialization;

    PGStudent(String name, int registerNo, String department, float cgpa, String hostelName, String mentorName, int noOfArrears, String specialization) {
        super(name, registerNo, department, cgpa, hostelName, mentorName, noOfArrears);
        this.specialization = specialization;
    }

    @Override
    void displayStudentDetails() {
        super.displayStudentDetails();
        System.out.println("Specialization: " + specialization);
    }
}

class UGStudent extends Student {
    UGStudent(String name, int registerNo, String department, float cgpa, String hostelName, String mentorName, int noOfArrears) {
        super(name, registerNo, department, cgpa, hostelName, mentorName, noOfArrears);
    }
}

public class exj57{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add PG Student");
            System.out.println("2. Add UG Student");
            System.out.println("3. Display PG Students");
            System.out.println("4. Display UG Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1) {
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();
                System.out.print("Enter register number: ");
                int registerNo = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                System.out.print("Enter department: ");
                String department = scanner.nextLine();
                System.out.print("Enter CGPA: ");
                float cgpa = scanner.nextFloat();
                scanner.nextLine();  // Consume newline
                System.out.print("Enter hostel name: ");
                String hostelName = scanner.nextLine();
                System.out.print("Enter mentor name: ");
                String mentorName = scanner.nextLine();
                System.out.print("Enter number of arrears: ");
                int noOfArrears = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                System.out.print("Enter specialization: ");
                String specialization = scanner.nextLine();

                PGStudent pgStudent = new PGStudent(name, registerNo, department, cgpa, hostelName, mentorName, noOfArrears, specialization);
                students.add(pgStudent);
            } else if (choice == 2) {
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();
                System.out.print("Enter register number: ");
                int registerNo = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                System.out.print("Enter department: ");
                String department = scanner.nextLine();
                System.out.print("Enter CGPA: ");
                float cgpa = scanner.nextFloat();
                scanner.nextLine();  // Consume newline
                System.out.print("Enter hostel name: ");
                String hostelName = scanner.nextLine();
                System.out.print("Enter mentor name: ");
                String mentorName = scanner.nextLine();
                System.out.print("Enter number of arrears: ");
                int noOfArrears = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                UGStudent ugStudent = new UGStudent(name, registerNo, department, cgpa, hostelName, mentorName, noOfArrears);
                students.add(ugStudent);
            } else if (choice == 3) {
                System.out.println("PG Students:");
                for (Student student : students) {
                    if (student instanceof PGStudent) {
                        student.displayStudentDetails();
                        System.out.println();
                    }
                }
            } else if (choice == 4) {
                System.out.println("UG Students:");
                for (Student student : students) {
                    if (student instanceof UGStudent) {
                        student.displayStudentDetails();
                        System.out.println();
                    }
                }
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
