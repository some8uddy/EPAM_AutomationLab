package stage1.javacollections.maintask;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Formatter;

public abstract class Sweets {

    protected final String sweetsType;

    protected final double sugarContent;    //grams in 100 grams of product

    protected final double overallWeight;   //kilograms

    protected final double price;           //per kilogram

    protected final double cost;

    protected Sweets(String sweetsType, double sugarContent, double overallWeight, double price, double cost) {
        this.sweetsType = sweetsType;
        this.sugarContent = sugarContent;
        this.overallWeight = overallWeight;
        this.price = price;
        this.cost = cost;
    }

    protected String getSweetsType() {
        return sweetsType;
    }

    protected double getSugarContent() {
        return sugarContent;
    }

    protected double getOverallWeight() {
        return overallWeight;
    }

    protected double getPrice() {
        return price;
    }

    protected double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        Formatter sf = new Formatter();
        DecimalFormatSymbols decimalSymbol = new DecimalFormatSymbols();
        decimalSymbol.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#.####", decimalSymbol);

        StringBuilder sb = new StringBuilder();
        sb.append(sf.format("     {sweetsType= %-10s", sweetsType))
          .append(", sugarContent=")
          .append(df.format(sugarContent))
          .append(", overallWeight=")
          .append(df.format(overallWeight))
          .append(", price=")
          .append(df.format(price))
          .append(", cost=")
          .append(df.format(cost));
        return sb.toString();
    }
}
