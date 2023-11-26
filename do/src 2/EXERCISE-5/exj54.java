import java.util.Scanner;

class Train {
    String name;
    int trainNo;
    String source;
    String destination;
    int numberOfTickets;
    double cost;

    Train(String name, int trainNo, String source, String destination, double cost) {
        this.name = name;
        this.trainNo = trainNo;
        this.source = source;
        this.destination = destination;
        this.cost = cost;
        this.numberOfTickets = 50; // Assuming an initial availability of 50 seats
    }

    public boolean checkSeatAvailability(int requiredTickets) {
        return numberOfTickets >= requiredTickets;
    }

    public void bookTicket(int requiredTickets) {
        if (checkSeatAvailability(requiredTickets)) {
            numberOfTickets -= requiredTickets;
            System.out.println(requiredTickets + " ticket(s) booked for " + name);
        } else {
            System.out.println("Sorry, there are not enough seats available for " + name);
        }
    }
}

class ChennaiExpress extends Train {
    ChennaiExpress(int trainNo) {
        super("Chennai Express", trainNo, "Chennai", "Bangalore", 1000);
    }
}

class CoimbatoreExpress extends Train {
    CoimbatoreExpress(int trainNo) {
        super("Coimbatore Express", trainNo, "Coimbatore", "Mumbai", 1200);
    }
}

public class exj54 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Train[] trains = new Train[3];
        trains[0] = new ChennaiExpress(12345);
        trains[1] = new ChennaiExpress(67890);
        trains[2] = new CoimbatoreExpress(54321);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Check Seat Availability");
            System.out.println("2. Book Ticket");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter Train Number: ");
                int trainNo = scanner.nextInt();
                System.out.print("Enter Number of Tickets: ");
                int tickets = scanner.nextInt();

                Train selectedTrain = findTrainByNumber(trainNo, trains);
                if (selectedTrain != null) {
                    boolean availability = selectedTrain.checkSeatAvailability(tickets);
                    if (availability) {
                        System.out.println("Seats are available for " + selectedTrain.name);
                    } else {
                        System.out.println("Sorry, there are not enough seats available for " + selectedTrain.name);
                    }
                } else {
                    System.out.println("Train not found.");
                }
            } else if (choice == 2) {
                System.out.print("Enter Train Number: ");
                int trainNo = scanner.nextInt();
                System.out.print("Enter Number of Tickets: ");
                int tickets = scanner.nextInt();

                Train selectedTrain = findTrainByNumber(trainNo, trains);
                if (selectedTrain != null) {
                    selectedTrain.bookTicket(tickets);
                } else {
                    System.out.println("Train not found.");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static Train findTrainByNumber(int trainNo, Train[] trains) {
        for (Train train : trains) {
            if (train.trainNo == trainNo) {
                return train;
            }
        }
        return null;
    }
}
