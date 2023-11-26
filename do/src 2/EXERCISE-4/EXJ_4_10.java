import java.util.Scanner;

class BankAccount {
    private String accountHolder;
    private long accountNumber;
    private double balance;

    public BankAccount(String accountHolder, long accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        if (initialBalance >= 500) {
            this.balance = initialBalance;
        } else {
            System.out.println("Initial balance must be a minimum of 500.");
            this.balance = 500; // Set balance to the minimum required if initial balance is too low.
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance - amount >= 500) {
                balance -= amount;
                System.out.println("Withdrawal successful. New balance: " + balance);
            } else {
                System.out.println("Withdrawal not allowed. Minimum balance requirement not met.");
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }
}

public class BankingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;

        while (true) {
            System.out.println("Banking Operations Menu");
            System.out.println("1. Create Account");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Create Account
                    if (account == null) {
                        System.out.print("Enter Account Holder Name: ");
                        String accountHolder = scanner.nextLine();
                        System.out.print("Enter Account Number: ");
                        long accountNumber = scanner.nextLong();
                        System.out.print("Enter Initial Balance: ");
                        double initialBalance = scanner.nextDouble();

                        account = new BankAccount(accountHolder, accountNumber, initialBalance);
                        System.out.println("Account created successfully.");
                    } else {
                        System.out.println("Account already exists. Please choose another option.");
                    }
                    break;
                case 2:
                    // Check Balance
                    if (account != null) {
                        account.checkBalance();
                    } else {
                        System.out.println("Account does not exist. Create an account first.");
                    }
                    break;
                case 3:
                    // Deposit Money
                    if (account != null) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("Account does not exist. Create an account first.");
                    }
                    break;
                case 4:
                    // Withdraw Money
                    if (account != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        account.withdraw(withdrawalAmount);
                    } else {
                        System.out.println("Account does not exist. Create an account first.");
                    }
                    break;
                case 5:
                    // Exit the program
                    System.out.println("Exiting the Banking Application.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
