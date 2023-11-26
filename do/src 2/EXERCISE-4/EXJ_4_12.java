import java.util.Scanner;

class Flight {
    private int flightNumber;
    private String destination;
    private float distance;
    private float fuel;

    private void calFuel() {
        if (distance <= 1000) {
            fuel = 500;
        } else if (distance > 1000 && distance <= 2000) {
            fuel = 1100;
        } else {
            fuel = 2200;
        }
    }

    public void feedInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Flight Number: ");
        flightNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Destination: ");
        destination = scanner.nextLine();

        System.out.print("Enter Distance: ");
        distance = scanner.nextFloat();

        calFuel(); // Calculate fuel based on distance
    }

    public void showInfo() {
        System.out.println("Flight Number: " + flightNumber);
        System.out.println("Destination: " + destination);
        System.out.println("Distance: " + distance + " km");
        System.out.println("Fuel Required: " + fuel + " liters");
    }
}

public class FlightApp {
    public static void main(String[] args) {
        Flight flight = new Flight();
        flight.feedInfo();
        flight.showInfo();
    }
}
