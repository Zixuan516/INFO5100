package assignment4.q3;

public class Sundae extends IceCream {
    private String topping;

    public Sundae(String name, int iceCreamCost, String topping, int toppingCost) {
        super(name, iceCreamCost);
        this.topping = topping;
        setCost(iceCreamCost + toppingCost);
    }

    public String getTopping() {
        return topping;
    }
}
