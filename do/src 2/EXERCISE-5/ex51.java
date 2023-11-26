import java.util.Scanner;

class Shape {
    private double width;
    private double height;

    public void setDimensions(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void findArea() {
        System.out.println("Area: " + (width * height));
    }
}

class Triangle extends Shape {
    @Override
    public void findArea() {
        System.out.println("Triangle Area: " + (0.5 * getWidth() * getHeight()));
    }
}

class Rectangle extends Shape {
    @Override
    public void findArea() {
        System.out.println("Rectangle Area: " + (getWidth() * getHeight()));
    }
}

public class ex51{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shape shape = null;

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Create Triangle");
            System.out.println("2. Create Rectangle");
            System.out.println("3. Calculate Area");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    shape = new Triangle();
                    System.out.print("Enter base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter height: ");
                    double height = scanner.nextDouble();
                    shape.setDimensions(base, height);
                    System.out.println("Triangle created!");
                    break;
                case 2:
                    shape = new Rectangle();
                    System.out.print("Enter width: ");
                    double width = scanner.nextDouble();
                    System.out.print("Enter height: ");
                    height = scanner.nextDouble();
                    shape.setDimensions(width, height);
                    System.out.println("Rectangle created!");
                    break;
                case 3:
                    if (shape != null) {
                        shape.findArea();
                    } else {
                        System.out.println("No shape created yet!");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            System.out.println();
        } while (choice != 4);

        scanner.close();
    }
}