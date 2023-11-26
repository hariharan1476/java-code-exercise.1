import java.util.Scanner;

public class EXJ_4_2 {
    private int totalCars;
    private double totalCash;

    public EXJ_4_2() {
        totalCars = 0;
        totalCash = 0.0;
    }

    public void payingCar() {
        totalCars++;
        totalCash += 50.0;
    }

    public void nopayCar() {
        totalCars++;
    }

    public void display() {
        System.out.println("Total Cars: " + totalCars);
        System.out.println("Total Cash Collected: " + totalCash + " rupees");
    }

    public static void main(String[] args) {
        EXJ_4_2 booth = new EXJ_4_2();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Press 'P' to count a paying car, 'N' to count a nonpaying car, or 'ESC' to exit.");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("P")) {
                booth.payingCar();
                System.out.println("Paying car counted.");
            } else if (input.equalsIgnoreCase("N")) {
                booth.nopayCar();
                System.out.println("Nonpaying car counted.");
            } else if (input.equalsIgnoreCase("ESC")) {
                booth.display();
                System.out.println("Exiting the program.");
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
