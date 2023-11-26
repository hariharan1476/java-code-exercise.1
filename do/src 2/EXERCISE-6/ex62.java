import java.util.Scanner;

interface MathsOperable {
    double add(double a, double b);
    double subtract(double a, double b);
    double multiply(double a, double b);
    double divide(double a, double b);
    double mod(double a, double b);
}

interface TrigonometricOperable {
    double sine(double angle);
    double cosine(double angle);
    double tan(double angle);
}

abstract class Calculator {
    protected double no1;
    protected double no2;
    protected double result;

    public Calculator(double no1, double no2) {
        this.no1 = no1;
        this.no2 = no2;
    }

    public abstract void performOperation();
}

class Addition extends Calculator implements MathsOperable {
    public Addition(double no1, double no2) {
        super(no1, no2);
    }

    @Override
    public void performOperation() {
        result = add(no1, no2);
    }

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return 0; // Not used for addition
    }

    @Override
    public double multiply(double a, double b) {
        return 0; // Not used for addition
    }

    @Override
    public double divide(double a, double b) {
        return 0; // Not used for addition
    }

    @Override
    public double mod(double a, double b) {
        return 0; // Not used for addition
    }
}
class Sine extends Calculator implements TrigonometricOperable {
    public Sine(double angle) {
        super(angle, 0); // no2 is not used for sine
    }

    @Override
    public void performOperation() {
        result = sine(no1);
    }

    @Override
    public double sine(double angle) {
        return Math.sin(Math.toRadians(angle));
    }

    @Override
    public double cosine(double angle) {
        return 0; // Not used for sine
    }

    @Override
    public double tan(double angle) {
        return 0; // Not used for sine
    }
}

public class ex62 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("Menu:");
            System.out.println("1. Addition");
            System.out.println("2. Sine");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter two numbers: ");
                    double num1 = scanner.nextDouble();
                    double num2 = scanner.nextDouble();
                    Addition addition = new Addition(num1, num2);
                    addition.performOperation();
                    System.out.println("Result: " + addition.result);
                    break;
                case 2:
                    System.out.print("Enter an angle in degrees: ");
                    double angle = scanner.nextDouble();
                    Sine sine = new Sine(angle);
                    sine.performOperation();
                    System.out.println("Sine: " + sine.result);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
            
        } while (choice != 3);
        
        scanner.close();
    }
}
