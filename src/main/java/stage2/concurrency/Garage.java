package stage2.concurrency;

public class Garage {
    private int roomAvailable;
    private long maxWaitingTimeInQueueMills;
    private boolean isEntreeAllowed = true;

    public Garage(int initialRoomAvailable, long maxWaitingTimeInQueueMills) {
        this.roomAvailable = initialRoomAvailable;
        this.maxWaitingTimeInQueueMills = maxWaitingTimeInQueueMills;
    }

    public boolean hasRoomAvailable() {
        return roomAvailable > 0;
    }

    public synchronized void parkInGarage(Car car) {
        car.setArrivalTimeMills(System.currentTimeMillis());
        while (!isEntreeAllowed) {
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
            isEntreeAllowed = false;
            System.out.printf("%s was parked in the garage, there is %d spots available:%n", car.getName(), --roomAvailable);
            if (hasRoomAvailable()) {
                isEntreeAllowed = true;
            }
        } else {
            System.out.printf("%s has been waiting too long and was redirected to another garage.%n", car.getName());
            car.setRedirected(true);
        }
    }

    private boolean exceededWaitingTime(Car car) {
        return System.currentTimeMillis() - car.getArrivalTimeMills() > maxWaitingTimeInQueueMills;
    }

    public synchronized void leaveGarage(Car car) {
        System.out.printf("%n%s has left the garage, there is %d spots available:%n",
            car.getName(), ++roomAvailable);
        isEntreeAllowed = true;
        this.notify();
    }
}