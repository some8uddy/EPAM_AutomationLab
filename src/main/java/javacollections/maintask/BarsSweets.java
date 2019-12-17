package javacollections.maintask;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class BarsSweets extends Sweets {

    private final double unitWeight;

    private final int count;

    public BarsSweets(String sweetsType, double sugarContent, double unitWeight, int count, double price) {
        super(sweetsType, sugarContent, unitWeight * count, price, count * price);
        this.unitWeight = unitWeight;
        this.count = count;
    }

    public double getUnitWeight() {
        return unitWeight;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        DecimalFormatSymbols decimalSymbol = new DecimalFormatSymbols();
        decimalSymbol.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#.####", decimalSymbol);

        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
          .append(", unitWeight=")
          .append(df.format(unitWeight))
          .append(", count=")
          .append(df.format(count));
        return sb.toString();
    }
}
