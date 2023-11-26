import java.util.concurrent.Semaphore;

class Airport {
    private Semaphore runway;

    public Airport() {
        this.runway = new Semaphore(1);
    }

    public void requestRunway(String airplaneName) {
        try {
            System.out.println(airplaneName + " is requesting a runway.");
            runway.acquire();
            System.out.println(airplaneName + " has been granted a runway.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void releaseRunway(String airplaneName) {
        System.out.println(airplaneName + " has released the runway.");
        runway.release();
    }
}

class Airplane implements Runnable {
    private String name;
    private Airport airport;
    private boolean isTakingOff;

    public Airplane(String name, Airport airport, boolean isTakingOff) {
        this.name = name;
        this.airport = airport;
        this.isTakingOff = isTakingOff;
    }

    @Override
    public void run() {
        if (isTakingOff) {
            airport.requestRunway(name);
            System.out.println(name + " is taking off.");
            // Perform takeoff operations
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            airport.releaseRunway(name);
        } else {
            airport.requestRunway(name);
            System.out.println(name + " is landing.");
            // Perform landing operations
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            airport.releaseRunway(name);
        }
    }
}

public class AirportSimulation {
    public static void main(String[] args) {
        Airport airport = new Airport();

        Thread airplane1 = new Thread(new Airplane("Airplane 1", airport, true));
        Thread airplane2 = new Thread(new Airplane("Airplane 2", airport, false));
        Thread airplane3 = new Thread(new Airplane("Airplane 3", airport, true));

        airplane1.start();
        airplane2.start();
        airplane3.start();
    }
}