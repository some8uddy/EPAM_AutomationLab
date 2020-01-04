package stage2.concurrency;

import java.util.Random;

public class Car implements Runnable {
    private String name;
    private Garage garage;
    private long arrivalTime;
    private boolean isRedirected = false;

    public Car(String name, Garage garage) {
        this.name = name;
        this.garage = garage;
    }

    public String getName() {
        return name;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(long arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setRedirected(boolean redirected) {
        this.isRedirected = redirected;
    }

    @Override
    public void run() {
        Random rnd = new Random();
        int parkingTime = rnd.nextInt(10);
        garage.parkInGarage(this);
        if (!isRedirected) {
            try {
                Thread.sleep(1000 * parkingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            garage.leaveGarage(this);
        }
    }
}