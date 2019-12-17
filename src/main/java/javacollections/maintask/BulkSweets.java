package javacollections.maintask;

public class BulkSweets extends Sweets {

    protected BulkSweets(String sweetsType, double sugarContent, double overallWeight, double price) {
        super(sweetsType, sugarContent, overallWeight, price, overallWeight * price);
    }
}
