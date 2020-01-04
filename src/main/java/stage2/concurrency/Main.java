package stage2.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

// Автостоянка. Доступно несколько машиномест.
// На одном месте может находиться только один автомобиль.
// Если все места заняты, то автомобиль не станет ждать больше определенного времени и уедет на другую стоянку.

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Car> cars = new ArrayList<>();

        int garageSize = 5;
        long maxWaitingTimeInQueueMills = 1000 * 5;
        Garage garage = new Garage(garageSize, maxWaitingTimeInQueueMills);

        int carsCount = 15;
        Random rnd = new Random();
        for (int i = 0; i < carsCount; i++) {
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