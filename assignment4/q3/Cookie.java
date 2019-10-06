package assignment4.q3;

public class Cookie extends DessertItem {
    private int number;
    private double pricePerDozen;

    public Cookie(String name, int number, double pricePerDozen) {
        super(name);
        this.number = number;
        this.pricePerDozen = pricePerDozen;
    }

    public int getCost() {
        double d = number * pricePerDozen / 12;
        return (int)Math.round(d);
    }

    public int getNumber() {
        return number;
    }

    public double getPricePerDozen() {
        return pricePerDozen;
    }

}
