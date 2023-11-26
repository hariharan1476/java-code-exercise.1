import java.util.Scanner;

interface ATMOperations {
    void displayBalance();

    void deposit(double amount);

    void withdraw(double amount) throws InsufficientBalanceException;

    void changePIN(int newPIN);

    boolean validatePIN(int enteredPIN) throws InvalidPinAttemptsException;
}

class InvalidPinAttemptsException extends Exception {
    public InvalidPinAttemptsException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class ATM implements ATMOperations {
    private int pinAttempts;
    private int pin;
    private double balance;

    public ATM(int pin, double initialBalance) {
        this.pin = pin;
        this.balance = initialBalance;
        this.pinAttempts = 0;
    }

    @Override
    public void displayBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
        displayBalance();
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance. Cannot withdraw $" + amount);
        }

        balance -= amount;
        System.out.println("Withdrawn: $" + amount);
        displayBalance();
    }

    @Override
    public void changePIN(int newPIN) {
        pin = newPIN;
        System.out.println("PIN changed successfully.");
    }

    @Override
    public boolean validatePIN(int enteredPIN) throws InvalidPinAttemptsException {
        if (enteredPIN != pin) {
            pinAttempts++;
            System.out.println("Invalid PIN. Attempts remaining: " + (3 - pinAttempts));

            if (pinAttempts >= 3) {
                throw new InvalidPinAttemptsException("Exceeded maximum attempts. Card blocked.");
            }

            return false;
        }

        return true;
    }
}

public class ATMProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize ATM with PIN and initial balance
        ATM atm = new ATM(1234, 1000.0);

        int choice;
        int enteredPIN;
        boolean loggedIn = false;

        do {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Log In");
            System.out.println("2. Display Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Change PIN");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter PIN: ");
                    enteredPIN = scanner.nextInt();
                    try {
                        loggedIn = atm.validatePIN(enteredPIN);
                    } catch (InvalidPinAttemptsException e) {
                        System.out.println("Exception: " + e.getMessage());
                        return; // Terminate the program if attempts exceed
                    }
                    break;
                case 2:
                    if (loggedIn) {
                        atm.displayBalance();
                    } else {
                        System.out.println("Please log in first.");
                    }
                    break;
                case 3:
                    if (loggedIn) {
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                    } else {
                        System.out.println("Please log in first.");
                    }
                    break;
                case 4:
                    if (loggedIn) {
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawalAmount = scanner.nextDouble();
                        try {
                            atm.withdraw(withdrawalAmount);
                        } catch (InsufficientBalanceException e) {
                            System.out.println("Exception: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Please log in first.");
                    }
                    break;
                case 5:
                    if (loggedIn) {
                        System.out.print("Enter new PIN: ");
                        int newPIN = scanner.nextInt();
                        atm.changePIN(newPIN);
                    } else {
                        System.out.println("Please log in first.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting ATM. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
