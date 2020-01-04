package stage2.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Автостоянка. Доступно несколько машиномест.
// На одном месте может находиться только один автомобиль.
// Если все места заняты, то автомобиль не станет ждать больше определенного времени и уедет на другую стоянку.

public class Main {
    private static List<Thread> cars = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        int garageSize = 5;
        long maxWaitingTimeInQueue = 1000 * 5;
        Garage garage = new Garage(garageSize, maxWaitingTimeInQueue);

        int carsCount = 50;
        Random rnd = new Random();
        for (int i = 0; i < carsCount; i++) {
            String carName = "Car" + i;
            Thread thread = new Thread(new Car(carName, garage));
            thread.start();
            cars.add(thread);
            Thread.sleep(1000 * rnd.nextInt(2));
        }
        for (Thread t : cars) {
            t.join();
        }
    }
}