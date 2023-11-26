import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Semaphore;

class Fruit {
    String type;

    public Fruit(String type) {
        this.type = type;
    }
}

class Farmer extends Thread {
    private String name;
    private String[] fruitTypes = {"Apple", "Orange", "Grape", "Watermelon"};
    private Queue<Fruit> market;

    public Farmer(String name, Queue<Fruit> market) {
        this.name = name;
        this.market = market;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (true) {
            String randomFruit = fruitTypes[random.nextInt(fruitTypes.length)];
            Fruit fruit = new Fruit(randomFruit);

            try {
                // Try to produce and add the fruit to the market
                market.add(fruit);
                System.out.println(name + " produced " + fruit.type + ". Available in the market: " + market.size());

                Thread.sleep(random.nextInt(2000)); // Simulating time taken to produce
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private String name;
    private String desiredFruit;
    private Queue<Fruit> market;

    public Consumer(String name, String desiredFruit, Queue<Fruit> market) {
        this.name = name;
        this.desiredFruit = desiredFruit;
        this.market = market;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (true) {
            try {
                // Try to consume the desired fruit from the market
                Fruit fruit;
                synchronized (market) {
                    while (market.isEmpty() || !market.peek().type.equals(desiredFruit)) {
                        System.out.println(name + " is waiting for " + desiredFruit);
                        market.wait();
                    }
                    fruit = market.poll();
                    System.out.println(name + " bought " + fruit.type + ". Available in the market: " + market.size());
                    market.notifyAll();
                }

                Thread.sleep(random.nextInt(3000)); // Simulating time taken to consume
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

public class FruitMarketSimulation {
    public static void main(String[] args) {
        int marketCapacity = 10;
        Queue<Fruit> market = new LinkedList<>();

        // Semaphores for controlling access to the market
        Semaphore marketSemaphore = new Semaphore(marketCapacity, true);

        // Farmers produce fruits
        Farmer farmer1 = new Farmer("Farmer 1", market);
        Farmer farmer2 = new Farmer("Farmer 2", market);

        // Consumers buy fruits
        Consumer consumer1 = new Consumer("Consumer 1", "Apple", market);
        Consumer consumer2 = new Consumer("Consumer 2", "Orange", market);
        Consumer consumer3 = new Consumer("Consumer 3", "Grape", market);
        Consumer consumer4 = new Consumer("Consumer 4", "Watermelon", market);

        farmer1.start();
        farmer2.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
    }
}
