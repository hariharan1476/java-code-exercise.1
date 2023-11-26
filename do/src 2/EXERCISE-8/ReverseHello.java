class ReverseHelloThread extends Thread {
    private int threadNum;

    public ReverseHelloThread(int threadNum) {
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        if (threadNum < 50) {
            ReverseHelloThread nextThread = new ReverseHelloThread(threadNum + 1);
            nextThread.start();
            try {
                nextThread.join(); // Wait for the next thread to finish before printing
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Hello from Thread " + threadNum + "!");
    }
}

public class ReverseHello {
    public static void main(String[] args) {
        ReverseHelloThread thread1 = new ReverseHelloThread(1);
        thread1.start();
    }
}
