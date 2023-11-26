class Worker {
    protected String name;
    protected double salaryRate;

    public Worker(String name, double salaryRate) {
        this.name = name;
        this.salaryRate = salaryRate;
    }

    public double computePay(int hoursWorked) {
        return 0; // Base class method; overridden in subclasses
    }

    public String getName() {
        return name;
    }
}

class DailyWorker extends Worker {
    public DailyWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }

    @Override
    public double computePay(int daysWorked) {
        return daysWorked * salaryRate; // Pay based on days worked
    }
}

class SalariedWorker extends Worker {
    public SalariedWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }

    @Override
    public double computePay(int hoursWorked) {
        return 40 * salaryRate; // Salaried workers get paid for 40 hours a week
    }
}

public class ex53{
    public static void main(String[] args) {
        Worker dailyWorker = new DailyWorker("John", 20.0);
        Worker salariedWorker = new SalariedWorker("Alice", 25.0);

        int daysWorked = 5;
        int hoursWorked = 45;

        double dailyWorkerPay = dailyWorker.computePay(daysWorked);
        double salariedWorkerPay = salariedWorker.computePay(hoursWorked);

        System.out.println("Weekly pay for " + dailyWorker.getName() + ": $" + dailyWorkerPay);
        System.out.println("Weekly pay for " + salariedWorker.getName() + ": $" + salariedWorkerPay);
    }
}
