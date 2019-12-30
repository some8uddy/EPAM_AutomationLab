package stage1.javacollections.maintask;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Gift {

    private final List<Sweets> sweets;

    public Gift() {
        this(new ArrayList<>());
    }

    public Gift(ArrayList<Sweets> sweets) {
        this.sweets = sweets;
    }

    public void addCandy(Sweets item) {
        sweets.add(item);
    }

    public Sweets removeCandy(int index) {
        return sweets.remove(index);
    }

    public Sweets removeLast() {
        return this.removeCandy(sweets.size() - 1);
    }

    public List<Sweets> getSweets() {
        return this.sweets;
    }

    public double getGiftWeight() {
        double weight = 0;
        for (Sweets item : sweets) {
            weight += item.getOverallWeight();
        }
        return weight;
    }

    public double getGiftCost() {
        double cost = 0;
        for (Sweets item : sweets) {
            cost += item.getCost();
        }
        return cost;
    }

    public void printSweets() {
        for (Sweets g : sweets){
            System.out.println(g.toString());
        }
    }

    public void sortBySugarContent() {
        sweets.sort(new Comparator<Sweets>() {
            @Override
            public int compare(Sweets o1, Sweets o2) {
                return Double.compare(o1.getSugarContent(),o2.getSugarContent());
            }
        });
    }

    public void sortByOverallWeight() {
        sweets.sort(new Comparator<Sweets>() {
            @Override
            public int compare(Sweets o1, Sweets o2) {
                return Double.compare(o1.getOverallWeight(),o2.getOverallWeight());
            }
        });
    }

    public void sortByPrice() {
        sweets.sort(new Comparator<Sweets>() {
            @Override
            public int compare(Sweets o1, Sweets o2) {
                return Double.compare(o1.getPrice(),o2.getPrice());
            }
        });
    }

    public void sortByCost() {
        sweets.sort(new Comparator<Sweets>() {
            @Override
            public int compare(Sweets o1, Sweets o2) {
                return Double.compare(o1.getCost(),o2.getCost());
            }
        });
    }

    public Gift filterBySugarContent(double lowerLevel, double higherLevel) {
        if (lowerLevel > higherLevel){
            double tmp = higherLevel;
            higherLevel = lowerLevel;
            lowerLevel = tmp;
        }
        Gift filteredGift = new Gift();
        for (Sweets item : sweets) {
            if (item.getSugarContent() >= lowerLevel && item.getSugarContent() <= higherLevel) {
                filteredGift.addCandy(item);
            }
        }
        return filteredGift;
    }

}
