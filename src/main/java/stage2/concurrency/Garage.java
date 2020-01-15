package stage2.concurrency;

public class Garage {
    private final long MAX_WAITING_TIME_IN_QUEUE_MILLS;
    private int roomAvailable;
    private boolean isEntryAllowed = true;

    public Garage(int initialRoomAvailable, long maxWaitingTimeInQueueMills) {
        this.roomAvailable = initialRoomAvailable;
        this.MAX_WAITING_TIME_IN_QUEUE_MILLS = maxWaitingTimeInQueueMills;
    }

    public boolean hasRoomAvailable() {
        return roomAvailable > 0;
    }

    public synchronized void parkInGarage(Car car) {
        car.setArrivalTimeMills(System.currentTimeMillis());
        while (!isEntryAllowed) {
            if (exceededWaitingTime(car)) {
                break;
            }
            try {
                wait(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (!exceededWaitingTime(car)) {
            isEntryAllowed = false;
            System.out.printf("%s was parked in the garage, there are %d spots available:%n", car.getName(), --roomAvailable);
            if (hasRoomAvailable()) {
                isEntryAllowed = true;
            }
        } else {
            System.out.printf("%s has been waiting too long and was redirected to another garage.%n", car.getName());
            car.setRedirected(true);
        }
    }

    private boolean exceededWaitingTime(Car car) {
        return System.currentTimeMillis() - car.getArrivalTimeMills() > MAX_WAITING_TIME_IN_QUEUE_MILLS;
    }

    public synchronized void leaveGarage(Car car) {
        System.out.printf("%n%s has left the garage, there are %d spots available:%n",
            car.getName(), ++roomAvailable);
        isEntryAllowed = true;
        this.notify();
    }
}