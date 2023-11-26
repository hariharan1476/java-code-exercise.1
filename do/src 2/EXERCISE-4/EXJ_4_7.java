import java.util.ArrayList;
import java.util.Scanner;

class Subject {
    private String subjectName;
    private String subjectCode;
    private int mark;
    private String grade;

    public Subject(String subjectName, String subjectCode, int mark) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.mark = mark;
        this.grade = calculateGrade(mark);
    }

    public String calculateGrade(int mark) {
        if (mark >= 90) {
            return "A+";
        } else if (mark >= 80) {
            return "A";
        } else if (mark >= 70) {
            return "B";
        } else if (mark >= 60) {
            return "C";
        } else if (mark >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    // Getters and setters for all attributes
}

class Student {
    private int registerNo;
    private String name;
    private String department;
    private String specialization;
    private int semester;
    private ArrayList<Subject> subjects;

    public Student(int registerNo, String name, String department, String specialization, int semester) {
        this.registerNo = registerNo;
        this.name = name;
        this.department = department;
        this.specialization = specialization;
        this.semester = semester;
        this.subjects = new ArrayList<>();
    }

    // Getters and setters for all attributes

    public void addSubject(String subjectName, String subjectCode, int mark) {
        subjects.add(new Subject(subjectName, subjectCode, mark));
    }

    public void displayStudentDetails() {
        System.out.println("Register No: " + registerNo);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Specialization: " + specialization);
        System.out.println("Semester: " + semester);
        System.out.println("Subject Details:");
        for (Subject subject : subjects) {
            System.out.println("Subject Name: " + subject.getSubjectName());
            System.out.println("Subject Code: " + subject.getSubjectCode());
            System.out.println("Mark: " + subject.getMark());
            System.out.println("Grade: " + subject.getGrade());
        }
    }
}

public class StudentGradeSheetApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("Student Grade Sheet Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display Student Grade Sheet");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    // Add Student
                    System.out.print("Enter Register No: ");
                    int registerNo = scanner.nextInt();
                    scanner.nextLine();
                    // Add code to get other student details from the user

                    // Create a Student object and add it to the ArrayList
                    students.add(new Student(registerNo, name, department, specialization, semester));
                    break;
                case 2:
                    // Edit Student
                    System.out.print("Enter Register No to edit: ");
                    int editRegisterNo = scanner.nextInt();
                    scanner.nextLine();
                    // Add code to find and edit the student details
                    break;
                case 3:
                    // Delete Student
                    System.out.print("Enter Register No to delete: ");
                    int deleteRegisterNo = scanner.nextInt();
                    scanner.nextLine();
                    // Add code to find and delete the student details
                    break;
                case 4:
                    // Display Student Grade Sheet
                    System.out.print("Enter Register No to display grade sheet: ");
                    int displayRegisterNo = scanner.nextInt();
                    scanner.nextLine();
                    // Add code to find and display the student's grade sheet
                    break;
                case 5:
                    // Exit the program
                    System.out.println("Exiting the Student Grade Sheet Management System.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
