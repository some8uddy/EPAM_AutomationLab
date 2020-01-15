package stage2.concurrency.using_semaphore;

import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


public class Parking {
    private static final int COUNT_OF_PARKING_SPOTS = 5;
    private static final int COUNT_OF_CARS = 25;
    private static boolean[] parkingSpots;
    private static Semaphore SEMAPHORE;
    private static int countOfParkingSpotsLeft = COUNT_OF_PARKING_SPOTS;

    public static class Car implements Runnable {
        private final String name;
        private final long maxWaitingTimeInQueueSeconds;

        public Car(String name, long maxWaitingTimeInQueueSeconds) {
            this.name = name;
            this.maxWaitingTimeInQueueSeconds = maxWaitingTimeInQueueSeconds;
        }

        @Override
        public void run() {
            System.out.printf("%s arrived to parking lot. (%d parking spots are available.)%n",
                name, countOfParkingSpotsLeft);
            try {
                if (SEMAPHORE.tryAcquire(maxWaitingTimeInQueueSeconds, TimeUnit.SECONDS)) {
                    int parkingSpotNumber = -1;
                    synchronized (parkingSpots) {
                        for (int i = 0; i < COUNT_OF_PARKING_SPOTS; i++)
                            if (parkingSpots[i]) {
                                parkingSpots[i] = false;
                                countOfParkingSpotsLeft--;
                                parkingSpotNumber = i;
                                System.out.printf("\t%s occupied parking spot %d. (%d spots are available).%n",
                                    name, i + 1, countOfParkingSpotsLeft);
                                break;
                            }
                    }

                    int parkingTimeSeconds = (int) (Math.random() * 10);
                    TimeUnit.SECONDS.sleep(parkingTimeSeconds);

                    synchronized (parkingSpots) {
                        parkingSpots[parkingSpotNumber] = true;
                        countOfParkingSpotsLeft++;
                    }

                    SEMAPHORE.release();
                    System.out.printf("%s left parking. (%d spots are available).%n",
                        name, countOfParkingSpotsLeft);
                } else {
                    System.out.printf("%s has been waiting too long and was redirected to another parking.%n", name);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        parkingSpots = new boolean[COUNT_OF_PARKING_SPOTS];
        Arrays.fill(parkingSpots, true);

        SEMAPHORE = new Semaphore(COUNT_OF_PARKING_SPOTS, true);

        long maxWaitingTimeInQueueSeconds = 5;
        for (int i = 1; i <= COUNT_OF_CARS; i++) {
            new Thread(new Car("Car-" + i, maxWaitingTimeInQueueSeconds)).start();
            TimeUnit.MILLISECONDS.sleep(200);
        }
    }
}