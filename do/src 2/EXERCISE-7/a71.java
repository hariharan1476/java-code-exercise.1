import java.util.Scanner;

interface Transaction {
    void deposit(double amount);
    void withdraw(double amount);
    void viewBalance();
}

interface Displayable {
    void display();
}

abstract class Account {
    String acc_name;
    int acc_no;
    double balance;

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
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    @Override
    public void viewBalance() {
        System.out.println("Account Balance: $" + balance);
    }

    @Override
    public void display() {
        System.out.println("Account Name: " + acc_name);
        System.out.println("Account Number: " + acc_no);
        viewBalance();
    }
}

public class a71 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your account name: ");
        String acc_name = scanner.nextLine();
        System.out.println("Enter your account number: ");
        int acc_no = scanner.nextInt();
        System.out.println("Enter initial balance: ");
        double balance = scanner.nextDouble();

        Bank account = new Bank(acc_name, acc_no, balance);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.println("4. View Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter the withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.viewBalance();
                    break;

                case 4:
                    account.display();
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
