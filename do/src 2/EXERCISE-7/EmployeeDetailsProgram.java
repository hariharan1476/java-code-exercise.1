class NameException extends Exception {
    public NameException(String message) {
        super(message);
    }
}

class AgeException extends Exception {
    public AgeException(String message) {
        super(message);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void validateEmployeeDetails() throws NameException, AgeException {
        if (name.matches(".*\\d+.*")) {
            throw new NameException("Employee name cannot contain a number.");
        }

        if (age > 50) {
            throw new AgeException("Employee age must be 50 or below.");
        }

        System.out.println("Employee details are valid: " + this.toString());
    }

    @Override
    public String toString() {
        return "Employee [Name: " + name + ", Age: " + age + "]";
    }
}

public class EmployeeDetailsProgram {
    public static void main(String[] args) {
        try {
            // Example: Creating an employee and validating details
            Employee employee = new Employee("John Doe", 45);
            employee.validateEmployeeDetails();

            // Uncomment the following lines to test exceptions
            // Employee invalidEmployee = new Employee("123", 55);
            // invalidEmployee.validateEmployeeDetails();

        } catch (NameException | AgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
