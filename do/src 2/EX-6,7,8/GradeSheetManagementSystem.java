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

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
        this.grade = calculateGrade(mark);
    }

    public String getGrade() {
        return grade;
    }

    private String calculateGrade(int mark) {
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
}

class Student {
    private String name;
    private String registerNo;
    private String department;
    private String specialization;
    private int semester;
    private ArrayList<Subject> subjects;

    public Student(String name, String registerNo, String department, String specialization, int semester) {
        this.name = name;
        this.registerNo = registerNo;
        this.department = department;
        this.specialization = specialization;
        this.semester = semester;
        this.subjects = new ArrayList<>();
    }

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

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void removeSubject(Subject subject) {
        subjects.remove(subject);
    }

    public void updateSubject(Subject subject, int newMark) {
        subject.setMark(newMark);
    }
}

public class GradeSheetManagementSystem {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Grade Sheet Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display Student Grade Sheet");
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
                    displayStudentGradeSheet();
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
        System.out.print("Semester: ");
        int semester = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Student student = new Student(name, registerNo, department, specialization, semester);
        boolean addMoreSubjects = true;
        while (addMoreSubjects) {
            System.out.println("Enter Subject Details:");
            System.out.print("Subject Name: ");
            String subjectName = scanner.nextLine();
            System.out.print("Subject Code: ");
            String subjectCode = scanner.nextLine();
            System.out.print("Mark: ");
            int mark = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            Subject subject = new Subject(subjectName, subjectCode, mark);
            student.addSubject(subject);

            System.out.print("Do you want to add another subject? (yes/no): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("no")) {
                addMoreSubjects = false;
            }
        }

        studentList.add(student);
        System.out.println("Student added successfully.");
    }

    private static void editStudent() {
        System.out.print("Enter Register No of the student to edit: ");
        String registerNo = scanner.nextLine();

        Student student = findStudentByRegisterNo(registerNo);
        if (student != null) {
            System.out.println("Enter new details for the student:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Department: ");
            String department = scanner.nextLine();
            System.out.print("Specialization: ");
            String specialization = scanner.nextLine();
            System.out.print("Semester: ");
            int semester = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            student.setName(name);
            student.setDepartment(department);
            student.setSpecialization(specialization);
            student.setSemester(semester);

            System.out.println("Student details updated successfully.");
        } else {
            System.out.println("Student not found with the given Register No.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter Register No of the student to delete: ");
        String registerNo = scanner.nextLine();

        Student student = findStudentByRegisterNo(registerNo);
        if (student != null) {
            studentList.remove(student);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found with the given Register No.");
        }
    }

    private static void displayStudentGradeSheet() {
        System.out.print("Enter Register No of the student to display grade sheet: ");
        String registerNo = scanner.nextLine();

        Student student = findStudentByRegisterNo(registerNo);
        if (student != null) {
            System.out.println("Grade Sheet for Student: " + student.getName());
            System.out.println("Register No: " + student.getRegisterNo());
            System.out.println("Department: " + student.getDepartment());
            System.out.println("Specialization: " + student.getSpecialization());
            System.out.println("Semester: " + student.getSemester());

            System.out.println("Subjects:");
            ArrayList<Subject> subjects = student.getSubjects();
            for (Subject subject : subjects) {
                System.out.println("Subject Name: " + subject.getSubjectName());
                System.out.println("Subject Code: " + subject.getSubjectCode());
                System.out.println("Mark: " + subject.getMark());
                System.out.println("Grade: " + subject.getGrade());
                System.out.println();
            }
        } else {
            System.out.println("Student not found with the given Register No.");
        }
    }

    private static Student findStudentByRegisterNo(String registerNo) {
        for (Student student : studentList) {
            if (student.getRegisterNo().equals(registerNo)) {
                return student;
            }
        }
        return null;
    }
}