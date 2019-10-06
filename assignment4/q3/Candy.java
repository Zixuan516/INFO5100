package assignment4.q3;

public class Candy extends DessertItem {
    private double weight;
    private double pricePerPound;

    public Candy(String name, double weight, double pricePerPound) {
        super(name);
        this.weight = weight;
        this.pricePerPound = pricePerPound;
    }

    public int getCost() {
        double d = weight * pricePerPound;
        return (int)Math.round(d);
    }

    public double getWeight() {
        return weight;
    }

    public double getPricePerPound() {
        return pricePerPound;
    }

}
