import java.util.Scanner;

class IncomeTax {
    String name;
    int age;
    double annualIncome;

    IncomeTax(String name, int age, double annualIncome) {
        this.name = name;
        this.age = age;
        this.annualIncome = annualIncome;
    }

    double findTax() {
        return 0.0;
    }
}

class Resident extends IncomeTax {
    Resident(String name, int age, double annualIncome) {
        super(name, age, annualIncome);
    }

    @Override
    double findTax() {
        if (annualIncome <= 250000) {
            return 0.0;
        } else if (annualIncome <= 500000) {
            return (annualIncome - 250000) * 0.05;
        } else if (annualIncome <= 750000) {
            return 12500 + (annualIncome - 500000) * 0.1;
        } else if (annualIncome <= 1000000) {
            return 37500 + (annualIncome - 750000) * 0.15;
        } else {
            return 75000 + (annualIncome - 1000000) * 0.2;
        }
    }
}

class SeniorCitizen extends IncomeTax {
    SeniorCitizen(String name, int age, double annualIncome) {
        super(name, age, annualIncome);
    }

    @Override
    double findTax() {
        if (annualIncome <= 250000) {
            return 0.0;
        } else if (annualIncome <= 500000) {
            return (annualIncome - 250000) * 0.05;
        } else if (annualIncome <= 750000) {
            return 12500 + (annualIncome - 500000) * 0.05;
        } else if (annualIncome <= 1000000) {
            return 32500 + (annualIncome - 750000) * 0.1;
        } else {
            return 62500 + (annualIncome - 1000000) * 0.15;
        }
    }
}

public class exj56 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Calculate Income Tax (Resident)");
            System.out.println("2. Calculate Income Tax (Senior Citizen)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            if (choice == 1 || choice == 2) {
                System.out.print("Enter your name: ");
                String name = scanner.next();

                System.out.print("Enter your age: ");
                int age = scanner.nextInt();

                System.out.print("Enter your annual income: ₹");
                double annualIncome = scanner.nextDouble();

                IncomeTax taxpayer;
                if (choice == 1) {
                    taxpayer = new Resident(name, age, annualIncome);
                } else {
                    taxpayer = new SeniorCitizen(name, age, annualIncome);
                }

                double tax = taxpayer.findTax();
                System.out.println("Income Tax for " + taxpayer.name + " is ₹" + tax);
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
