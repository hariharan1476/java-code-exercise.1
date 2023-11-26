import java.util.Scanner;

class Fuel {
    String fuelName;
    String state;
    double cost;

    Fuel(String fuelName, String state, double cost) {
        this.fuelName = fuelName;
        this.state = state;
        this.cost = cost;
    }

    double calculateCost(double liters) {
        return liters * cost;
    }

    void printDetails(String customerName, double liters) {
        System.out.println("Customer Name: " + customerName);
        System.out.println("State: " + state);
        System.out.println("Fuel Type: " + fuelName);
        System.out.println("Liters Consumed: " + liters);
        System.out.println("Total Cost: ₹" + calculateCost(liters));
    }
}

class Petrol extends Fuel {
    Petrol(String state) {
        super("Petrol", state, getPetrolCost(state));
    }

    private static double getPetrolCost(String state) {
        switch (state) {
            case "Tamil Nadu":
                return 97.46;
            case "Kerala":
                return 98.35;
            case "Karnataka":
                return 99.61;
            default:
                return 0.0;
        }
    }
}

class Diesel extends Fuel {
    Diesel(String state) {
        super("Diesel", state, getDieselCost(state));
    }

    private static double getDieselCost(String state) {
        switch (state) {
            case "Tamil Nadu":
                return 96.08;
            case "Kerala":
                return 97.37;
            case "Karnataka":
                return 98.61;
            default:
                return 0.0;
        }
    }
}

class Kerosene extends Fuel {
    Kerosene(String state) {
        super("Kerosene", state, getKeroseneCost(state));
    }

    private static double getKeroseneCost(String state) {
        switch (state) {
            case "Tamil Nadu":
                return 25.7;
            case "Kerala":
                return 26.4;
            case "Karnataka":
                return 27.6;
            default:
                return 0.0;
        }
    }
}

class AutoLPGGas extends Fuel {
    AutoLPGGas(String state) {
        super("Auto LPG Gas", state, getAutoLPGGasCost(state));
    }

    private static double getAutoLPGGasCost(String state) {
        switch (state) {
            case "Tamil Nadu":
                return 70.33;
            case "Kerala":
                return 71.27;
            case "Karnataka":
                return 72.08;
            default:
                return 0.0;
        }
    }
}

public class exj55{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Calculate Fuel Cost");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.print("Enter your name: ");
                String customerName = scanner.next();

                System.out.print("Enter the state (Tamil Nadu/Kerala/Karnataka): ");
                String state = scanner.next();

                System.out.print("Enter the fuel type (Petrol/Diesel/Kerosene/Auto LPG Gas): ");
                String fuelType = scanner.next();

                System.out.print("Enter the number of liters consumed: ");
                double liters = scanner.nextDouble();

                Fuel fuel;
                switch (fuelType) {
                    case "Petrol":
                        fuel = new Petrol(state);
                        break;
                    case "Diesel":
                        fuel = new Diesel(state);
                        break;
                    case "Kerosene":
                        fuel = new Kerosene(state);
                        break;
                    case "Auto LPG Gas":
                        fuel = new AutoLPGGas(state);
                        break;
                    default:
                        System.out.println("Invalid fuel type.");
                        continue;
                }

                fuel.printDetails(customerName, liters);
            } else if (choice == 2) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
