import java.util.Scanner;

interface Transaction {
    void deposit(double amount);

    void withdraw(double amount);

    double viewBalance();
}

interface Displayable {
    void display();
}

abstract class Account {
    protected String acc_name;
    protected int acc_no;
    protected double balance;

    public Account(String acc_name, int acc_no, double balance) {
        this.acc_name = acc_name;
        this.acc_no = acc_no;
        this.balance = balance;
    }
}

class Bank extends Account implements Transaction, Displayable {
  
    public Bank(String acc_name, int acc_no, double balance) {
        super(acc_name, acc_no, balance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }

    @Override
    public double viewBalance() {
        return balance;
    }

    @Override
    public void display() {
        System.out.println("Account Name: " + acc_name);
        System.out.println("Account Number: " + acc_no);
        System.out.println("Balance: $" + balance);
    }
}

public class ex61 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Banking Application");

        Bank bankAccount = new Bank("John Doe", 12345, 1000.0);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Enquiry");
            System.out.println("4. View Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter the withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    bankAccount.withdraw(withdrawalAmount);
                    break;

                case 3:
                    System.out.println("Account Balance: $" + bankAccount.viewBalance());
                    break;

                case 4:
                    bankAccount.display();
                    break;

                case 5:
                    System.out.println("Thank you for using the Banking Application. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
