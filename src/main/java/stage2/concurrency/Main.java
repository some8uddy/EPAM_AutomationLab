package stage2.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

// Автостоянка. Доступно несколько машиномест.
// На одном месте может находиться только один автомобиль.
// Если все места заняты, то автомобиль не станет ждать больше определенного времени и уедет на другую стоянку.

public class Main {

    public static final int GARAGE_SIZE = 5;
    public static final long MAX_WAITING_TIME_IN_QUEUE_MILLS = 1000 * 5;
    public static final int CARS_COUNT = 15;

    public static void main(String[] args) throws InterruptedException {
        List<Car> cars = new ArrayList<>();
        Garage garage = new Garage(GARAGE_SIZE, MAX_WAITING_TIME_IN_QUEUE_MILLS);

        Random rnd = new Random();
        for (int i = 0; i < CARS_COUNT; i++) {
            String carName = "Car" + i;
            Car car = new Car(carName, garage);
            cars.add(car);
            new Thread(car).start();
            TimeUnit.SECONDS.sleep(rnd.nextInt(2));
        }

        TimeUnit.SECONDS.sleep(5);

        for (Car c : cars) {
            c.disable();
        }
    }
}