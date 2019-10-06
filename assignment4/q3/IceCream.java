package assignment4.q3;

public class IceCream extends DessertItem {
    private int cost;

    public IceCream(String name, int cost) {
        super(name);
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

}
