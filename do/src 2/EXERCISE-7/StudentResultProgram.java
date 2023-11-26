class LengthException extends Exception {
    public LengthException(String message) {
        super(message);
    }
}

class FailedException extends Exception {
    public FailedException(String message) {
        super(message);
    }
}

class NotFirstClassException extends Exception {
    public NotFirstClassException(String message) {
        super(message);
    }
}

class FirstClassException extends Exception {
    public FirstClassException(String message) {
        super(message);
    }
}

class Student {
    private String name;
    private int[] marks;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public void checkNameLength() throws LengthException {
        if (name.length() > 7) {
            throw new LengthException("Name length should be less than or equal to 7 characters.");
        }
    }

    public void checkResult() throws FailedException, NotFirstClassException, FirstClassException {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }

        double average = sum / (double) marks.length;

        if (average < 50) {
            throw new FailedException("Student failed with an average below 50.");
        } else if (average >= 50 && average < 75) {
            throw new NotFirstClassException("Student got Second Class with an average between 50 and 75.");
        } else {
            throw new FirstClassException("Student got First Class with an average above 75.");
        }
    }
}

public class StudentResultProgram {
    public static void main(String[] args) {
        try {
            // Example: Creating a student and checking results
            int[] marks = {70, 80, 90};
            Student student = new Student("John", marks);

            student.checkNameLength();
            student.checkResult();
            System.out.println("Student passed all checks.");

        } catch (LengthException | FailedException | NotFirstClassException | FirstClassException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
