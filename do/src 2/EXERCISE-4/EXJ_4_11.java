import java.util.Scanner;

class ATM {
    private int accountNumber;
    private int pin;
    private double balance;

    public ATM(int accountNumber, int pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount % 100 == 0) {
            if (balance - amount >= 500) {
                balance -= amount;
                System.out.println("Withdrawal successful. New balance: " + balance);
            } else {
                System.out.println("Withdrawal not allowed. Minimum balance requirement not met.");
            }
        } else {
            System.out.println("Withdrawal not allowed. Amount must be a multiple of 100.");
        }
    }

    public void changePin(int newPin) {
        pin = newPin;
        System.out.println("PIN changed successfully.");
    }

    public boolean validatePin(int enteredPin) {
        return pin == enteredPin;
    }

    public void checkBalance() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }
}

public class ATMApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = null;

        while (true) {
            System.out.println("ATM Operations Menu");
            System.out.println("1. Insert ATM Card");
            System.out.println("2. Balance Enquiry");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Insert ATM Card
                    if (atm == null) {
                        System.out.print("Enter Account Number: ");
                        int accountNumber = scanner.nextInt();
                        System.out.print("Enter PIN: ");
                        int pin = scanner.nextInt();
                        System.out.print("Enter Initial Balance: ");
                        double initialBalance = scanner.nextDouble();

                        atm = new ATM(accountNumber, pin, initialBalance);
                        System.out.println("ATM Card inserted successfully.");
                    } else {
                        System.out.println("ATM Card already inserted. Please choose another option.");
                    }
                    break;
                case 2:
                    // Balance Enquiry
                    if (atm != null) {
                        System.out.println("Please enter your PIN: ");
                        int enteredPin = scanner.nextInt();
                        if (atm.validatePin(enteredPin)) {
                            atm.checkBalance();
                        } else {
                            System.out.println("Invalid PIN. Please try again.");
                        }
                    } else {
                        System.out.println("ATM Card not inserted. Insert your ATM Card first.");
                    }
                    break;
                case 3:
                    // Withdraw Money
                    if (atm != null) {
                        System.out.println("Please enter your PIN: ");
                        int enteredPin = scanner.nextInt();
                        if (atm.validatePin(enteredPin)) {
                            System.out.print("Enter withdrawal amount: ");
                            double withdrawalAmount = scanner.nextDouble();
                            atm.withdraw(withdrawalAmount);
                        } else {
                            System.out.println("Invalid PIN. Please try again.");
                        }
                    } else {
                        System.out.println("ATM Card not inserted. Insert your ATM Card first.");
                    }
                    break;
                case 4:
                    // Change PIN
                    if (atm != null) {
                        System.out.println("Please enter your current PIN: ");
                        int enteredPin = scanner.nextInt();
                        if (atm.validatePin(enteredPin)) {
                            System.out.print("Enter new PIN: ");
                            int newPin = scanner.nextInt();
                            atm.changePin(newPin);
                        } else {
                            System.out.println("Invalid PIN. Please try again.");
                        }
                    } else {
                        System.out.println("ATM Card not inserted. Insert your ATM Card first.");
                    }
                    break;
                case 5:
                    // Exit the program
                    System.out.println("Exiting the ATM Application.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
