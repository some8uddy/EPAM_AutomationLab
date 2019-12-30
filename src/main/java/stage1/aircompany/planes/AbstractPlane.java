package stage1.aircompany.planes;

import java.util.Objects;

public abstract class AbstractPlane {

    final String model;
    private final int maxSpeed;
    private final int maxFlightDistance;
    private final int maxLoadCapacity;

    AbstractPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxFlightDistance() {
        return maxFlightDistance;
    }

    public int getMaxLoadCapacity() {
        return this.maxLoadCapacity;
    }

    @Override
    public String toString() {
        return "Plane{"
            + "model='"
            + model
            + '\''
            + ", maxSpeed="
            + maxSpeed
            + ", maxFlightDistance="
            + maxFlightDistance
            + ", maxLoadCapacity="
            + maxLoadCapacity
            + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AbstractPlane)) {
            return false;
        }
        AbstractPlane plane = (AbstractPlane) object;
        return maxSpeed == plane.maxSpeed
            && maxFlightDistance == plane.maxFlightDistance
            && maxLoadCapacity == plane.maxLoadCapacity
            && Objects.equals(model, plane.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }
}
