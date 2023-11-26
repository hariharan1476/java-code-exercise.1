class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited: " + amount);
        displayBalance();
    }

    public synchronized void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: " + amount);
        } else {
            System.out.println(Thread.currentThread().getName() + " Insufficient funds for withdrawal.");
        }
        displayBalance();
    }

    public synchronized void displayBalance() {
        System.out.println("Current Balance: " + balance);
        System.out.println();
    }
}

class TransactionThread extends Thread {
    private BankAccount account;
    private boolean isDeposit;
    private double amount;

    public TransactionThread(BankAccount account, boolean isDeposit, double amount) {
        this.account = account;
        this.isDeposit = isDeposit;
        this.amount = amount;
    }

    @Override
    public void run() {
        if (isDeposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
    }
}

public class BankAc {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        // Create multiple threads for deposits and withdrawals
        TransactionThread depositThread1 = new TransactionThread(account, true, 200);
        TransactionThread depositThread2 = new TransactionThread(account, true, 300);

        TransactionThread withdrawThread1 = new TransactionThread(account, false, 150);
        TransactionThread withdrawThread2 = new TransactionThread(account, false, 400);

        // Start the threads
        depositThread1.start();
        depositThread2.start();
        withdrawThread1.start();
        withdrawThread2.start();
    }
}
