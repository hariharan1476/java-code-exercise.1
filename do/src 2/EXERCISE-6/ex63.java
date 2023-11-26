import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Define the Academic interface
interface Academic {
    void calcAcademicCredit();
    void registerSub(String subject);
    void assignFaculty(String facultyName);
}

// Define the NonAcademic interface
interface NonAcademic {
    void calcNonAcademicCredit();
    void registerClub(String clubName);
}

// Define the Course abstract class
abstract class Course {
    protected String name;
    protected int reg_no;
    protected List<String> subjects;
    protected String faculty;
    protected List<String> non_acad_clubs;

    public Course(String name, int reg_no) {
        this.name = name;
        this.reg_no = reg_no;
        this.subjects = new ArrayList<>();
        this.non_acad_clubs = new ArrayList<>();
    }

    public abstract void displayDetails();
}

// Implement the Student class that inherits Course and implements Academic and NonAcademic interfaces
class Student extends Course implements Academic, NonAcademic {
    public Student(String name, int reg_no) {
        super(name, reg_no);
    }

    @Override
    public void calcAcademicCredit() {
        // Logic to calculate academic credits
        // Example: Credits calculated based on the subjects registered
        int academicCredits = subjects.size() * 3;
        System.out.println("Academic Credits: " + academicCredits);
    }

    @Override
    public void registerSub(String subject) {
        subjects.add(subject);
    }

    @Override
    public void assignFaculty(String facultyName) {
        faculty = facultyName;
    }

    @Override
    public void calcNonAcademicCredit() {
        // Logic to calculate non-academic credits
        // Example: Credits calculated based on the clubs registered
        int nonAcademicCredits = non_acad_clubs.size() * 2;
        System.out.println("Non-Academic Credits: " + nonAcademicCredits);
    }

    @Override
    public void registerClub(String clubName) {
        non_acad_clubs.add(clubName);
    }

    @Override
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Registration Number: " + reg_no);
        System.out.println("Faculty: " + faculty);
        System.out.println("Subjects Registered: " + subjects);
        System.out.println("Non-Academic Clubs: " + non_acad_clubs);
    }
}

// Main class to demonstrate the operations
public class ex63 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a student object
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter registration number: ");
        int regNumber = scanner.nextInt();
        Student student = new Student(studentName, regNumber);

        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Register Subject");
            System.out.println("2. Assign Faculty");
            System.out.println("3. Register Club");
            System.out.println("4. Calculate Academic Credits");
            System.out.println("5. Calculate Non-Academic Credits");
            System.out.println("6. Display Student Details");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter subject: ");
                    String subject = scanner.next();
                    student.registerSub(subject);
                    break;
                case 2:
                    System.out.print("Enter faculty name: ");
                    String facultyName = scanner.next();
                    student.assignFaculty(facultyName);
                    break;
                case 3:
                    System.out.print("Enter club name: ");
                    String clubName = scanner.next();
                    student.registerClub(clubName);
                    break;
                case 4:
                    student.calcAcademicCredit();
                    break;
                case 5:
                    student.calcNonAcademicCredit();
                    break;
                case 6:
                    student.displayDetails();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }

        } while (choice != 7);

        scanner.close();
    }
}
