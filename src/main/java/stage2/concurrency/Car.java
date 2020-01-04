package stage2.concurrency;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Car implements Runnable {
    private String name;
    private Garage garage;
    private long arrivalTimeMills;
    private boolean isRedirected;
    private boolean isActive;

    public Car(String name, Garage garage) {
        this.name = name;
        this.garage = garage;
        this.isRedirected = false;
        this.isActive = true;
    }

    public String getName() {
        return name;
    }

    public long getArrivalTimeMills() {
        return arrivalTimeMills;
    }

    public void setArrivalTimeMills(long arrivalTimeMills) {
        this.arrivalTimeMills = arrivalTimeMills;
    }

    public void setRedirected(boolean redirected) {
        this.isRedirected = redirected;
    }

    public void disable() {
        this.isActive = false;
    }

    @Override
    public void run() {
        while (isActive) {
            Random rnd = new Random();
            int parkingTimeSeconds = rnd.nextInt(10);
            garage.parkInGarage(this);
            if (!isRedirected) {
                try {
                    TimeUnit.SECONDS.sleep(parkingTimeSeconds);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                garage.leaveGarage(this);
            }
            isRedirected = false;
        }
    }
}