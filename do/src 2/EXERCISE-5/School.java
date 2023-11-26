import java.util.ArrayList;
import java.util.Scanner;

class Student {
    protected String name;
    protected int registerNo;
    protected String department;
    protected double cgpa;
    protected String hostelName;
    protected String mentorName;
    protected int noOfArrears;

    public Student(String name, int registerNo, String department, double cgpa, String hostelName, String mentorName,
            int noOfArrears) {
        this.name = name;
        this.registerNo = registerNo;
        this.department = department;
        this.cgpa = cgpa;
        this.hostelName = hostelName;
        this.mentorName = mentorName;
        this.noOfArrears = noOfArrears;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Register No: " + registerNo);
        System.out.println("Department: " + department);
        System.out.println("CGPA: " + cgpa);
        System.out.println("Hostel Name: " + hostelName);
        System.out.println("Mentor Name: " + mentorName);
        System.out.println("Number of Arrears: " + noOfArrears);
    }
}

class PGStudent extends Student {
    private String specialization;

    public PGStudent(String name, int registerNo, String department, double cgpa, String hostelName,
            String mentorName, int noOfArrears, String specialization) {
        super(name, registerNo, department, cgpa, hostelName, mentorName, noOfArrears);
        this.specialization = specialization;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Specialization: " + specialization);
    }
}

class UGStudent extends Student {
    public UGStudent(String name, int registerNo, String department, double cgpa, String hostelName,
            String mentorName, int noOfArrears) {
        super(name, registerNo, department, cgpa, hostelName, mentorName, noOfArrears);
    }
}

public class School {
    private static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Display PG Students");
            System.out.println("4. Display UG Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    displayPGStudents();
                    break;
                case 4:
                    displayUGStudents();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.next();
        System.out.print("Enter register number: ");
        int registerNo = scanner.nextInt();
        System.out.print("Enter department: ");
        String department = scanner.next();
        System.out.print("Enter CGPA: ");
        double cgpa = scanner.nextDouble();
        System.out.print("Enter hostel name: ");
        String hostelName = scanner.next();
        System.out.print("Enter mentor name: ");
        String mentorName = scanner.next();
        System.out.print("Enter number of arrears: ");
        int noOfArrears = scanner.nextInt();

        System.out.println("1. PG Student");
        System.out.println("2. UG Student");
        System.out.print("Enter student type: ");
        int studentType = scanner.nextInt();

        if (studentType == 1) {
            System.out.print("Enter specialization: ");
            String specialization = scanner.next();
            PGStudent pgStudent = new PGStudent(name, registerNo, department, cgpa, hostelName, mentorName,
                    noOfArrears, specialization);
            studentList.add(pgStudent);
            System.out.println("PG Student added successfully!");
        } else if (studentType == 2) {
            UGStudent ugStudent = new UGStudent(name, registerNo, department, cgpa, hostelName, mentorName,
                    noOfArrears);
            studentList.add(ugStudent);
            System.out.println("UG Student added successfully!");
        } else {
            System.out.println("Invalid student type! Please try again.");
        }
    }

    private static void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found!");
        } else {
            for (Student student : studentList) {
                student.displayDetails();
                System.out.println("--------------------");
            }
        }
    }

    private static void displayPGStudents() {
        boolean foundPGStudents = false;
        
        for (Student student : studentList) {
            if (student instanceof PGStudent) {
                foundPGStudents = true;
                student.displayDetails();
                System.out.println("--------------------");
            }
        }

        if (!foundPGStudents) {
            System.out.println("No PG students found!");
        }
    }

    private static void displayUGStudents() {
        boolean foundUGStudents = false;
        
        for (Student student : studentList) {
            if (student instanceof UGStudent) {
                foundUGStudents = true;
                student.displayDetails();
                System.out.println("--------------------");
            }
        }

        if (!foundUGStudents) {
            System.out.println("No UG students found!");
        }
    }
}