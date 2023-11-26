import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private String registerNo;
    private String department;
    private String specialization;
    private double cgpa;
    private String hostelName;
    private String mentorName;
    private int noOfArrears;

    // Constructor
    public Student(String name, String registerNo, String department, String specialization, double cgpa, String hostelName, String mentorName, int noOfArrears) {
        this.name = name;
        this.registerNo = registerNo;
        this.department = department;
        this.specialization = specialization;
        this.cgpa = cgpa;
        this.hostelName = hostelName;
        this.mentorName = mentorName;
        this.noOfArrears = noOfArrears;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public String getHostelName() {
        return hostelName;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public int getNoOfArrears() {
        return noOfArrears;
    }

    public void setNoOfArrears(int noOfArrears) {
        this.noOfArrears = noOfArrears;
    }
}

public class StudentManagementSystem {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display Student Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    editStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    displayStudentDetails();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }

    private static void addStudent() {
        System.out.println("Enter Student Details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Register No: ");
        String registerNo = scanner.nextLine();
        System.out.print("Department: ");
        String department = scanner.nextLine();
        System.out.print("Specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("CGPA: ");
        double cgpa = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character
        System.out.print("Hostel Name: ");
        String hostelName = scanner.nextLine();
        System.out.print("Mentor Name: ");
        String mentorName = scanner.nextLine();
        System.out.print("Number of Arrears: ");
        int noOfArrears = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Student student = new Student(name, registerNo, department, specialization, cgpa, hostelName, mentorName, noOfArrears);
        studentList.add(student);

        System.out.println("Student added successfully.");
    }

    private static void editStudent() {
        System.out.print("Enter the Register No of the student to edit: ");
        String registerNo = scanner.nextLine();

        boolean found = false;
        for (Student student : studentList) {
            if (student.getRegisterNo().equals(registerNo)) {
                System.out.println("Enter new details for the student:");
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Department: ");
                String department = scanner.nextLine();
                System.out.print("Specialization: ");
                String specialization = scanner.nextLine();
                System.out.print("CGPA: ");
                double cgpa = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Hostel Name: ");
                String hostelName = scanner.nextLine();
                System.out.print("Mentor Name: ");
                String mentorName = scanner.nextLine();
                System.out.print("Number of Arrears: ");
                int noOfArrears = scanner.nextInt();
                scanner.nextLine();

                student.setName(name);
                student.setDepartment(department);
                student.setSpecialization(specialization);
                student.setCgpa(cgpa);
                student.setHostelName(hostelName);
                student.setMentorName(mentorName);
                student.setNoOfArrears(noOfArrears);

                System.out.println("Student details updated successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter the Register No of the student to delete: ");
        String registerNo = scanner.nextLine();

        boolean found = false;
        for (Student student : studentList) {
            if (student.getRegisterNo().equals(registerNo)) {
                studentList.remove(student);
                System.out.println("Student deleted successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    private static void displayStudentDetails() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            System.out.println("Student Details:");
            for (Student student : studentList) {
                System.out.println("Name: " + student.getName());
                System.out.println("Register No: " + student.getRegisterNo());
                System.out.println("Department: " + student.getDepartment());
                System.out.println("Specialization: " + student.getSpecialization());
                System.out.println("CGPA: " + student.getCgpa());
                System.out.println("Hostel Name: " + student.getHostelName());
                System.out.println("Mentor Name: " + student.getMentorName());
                System.out.println("Number of Arrears: " + student.getNoOfArrears());
                System.out.println();
            }
        }
    }
}