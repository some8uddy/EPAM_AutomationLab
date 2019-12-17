package aircompany;

import aircompany.models.MilitaryType;
import aircompany.planes.AbstractPlane;
import aircompany.planes.ExperimentalPlane;
import aircompany.planes.MilitaryPlane;
import aircompany.planes.PassengerPlane;

import java.util.*;

public class Airport {

    private List<? extends AbstractPlane> planes;

    public List<? extends AbstractPlane> getPlanes() {
        return planes;
    }

    public List<PassengerPlane> getPassengerPlane() {
        List<? extends AbstractPlane> planes = this.planes;
        List<PassengerPlane> passengerPlanes = new ArrayList<>();
        for (AbstractPlane plane : planes) {
            if (plane instanceof PassengerPlane) {
                passengerPlanes.add((PassengerPlane) plane);
            }
        }
        return passengerPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (AbstractPlane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlane();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (int i = 0; i < passengerPlanes.size(); i++) {
            if (passengerPlanes.get(i).getPassengersCapacity()
                > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlanes.get(i);
            }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (int i = 0; i < militaryPlanes.size(); i++) {
            MilitaryPlane plane = militaryPlanes.get(i);
            if (plane.getType() == MilitaryType.TRANSPORT) {
                transportMilitaryPlanes.add(plane);
            }
        }
        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane plane : militaryPlanes) {
            if (plane.getType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(plane);
            }
        }
        return bomberMilitaryPlanes;
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (AbstractPlane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    private void print(Collection<? extends AbstractPlane> collection) {
        for (AbstractPlane plane : collection) {
            System.out.println(plane);
        }
    }

    public Airport sortByMaxDistance() {
        Collections.sort(
            planes,
            new Comparator<AbstractPlane>() {
                public int compare(AbstractPlane o1, AbstractPlane o2) { // me o1 o2
                    return o1.getMaxFlightDistance() - o2.getMaxFlightDistance();
                }
            });
        return this;
    }

    public Airport sortByMaxSpeed() {
        Collections.sort(
            planes,
            new Comparator<AbstractPlane>() {
                public int compare(AbstractPlane o1, AbstractPlane o2) {
                    return o1.getMaxSpeed() - o2.getMaxSpeed();
                }
            });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(
            planes,
            new Comparator<AbstractPlane>() {
                public int compare(AbstractPlane o1, AbstractPlane o2) {
                    return o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity();
                }
            });
        return this;
    }

    @Override
    public String toString() {
        return "Airport{" + "Planes=" + planes.toString() + '}';
    }

    // Constructor
    public Airport(List<? extends AbstractPlane> planes) {
        this.planes = planes;
    }
}
