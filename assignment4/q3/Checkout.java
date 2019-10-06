package assignment4.q3;

import java.util.ArrayList;
import java.util.List;


public class Checkout {
    List<DessertItem> list;
    private DessertShop shop;

    public Checkout() {
        list = new ArrayList<>();
        shop = new DessertShop();
    }

    public int numberOfItems() {
        return list.size();
    }

    public void enterItem(DessertItem item) {
        list.add(item);
    }

    public void clear() {
        list = new ArrayList<>();
    }

    public int totalCost() {
        int total = 0;
        for (int i = 0; i < list.size(); i++) {
            total = total + list.get(i).getCost();
        }
        return total;
    }

    public int totalTax() {
        return (int)Math.round(this.totalCost() * shop.getTaxRate());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("       M & M Dessert Shop       \n      --------------------      ");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getClass() == IceCream.class) {
                IceCream iceCream = (IceCream) list.get(i);
                sb.append("\n" + iceCream.name);
                for (int j = 0; j < 28 - iceCream.name.length(); j++) {
                    sb.append(' ');
                }
                sb.append((double)iceCream.getCost() / 100);
            }

            if (list.get(i).getClass() == Sundae.class) {
                Sundae sundae = (Sundae) list.get(i);
                sb.append("\n" + sundae.getTopping() + "Sundae with");
                sb.append("\n" + sundae.name);
                for (int j = 0; j < 28 - sundae.name.length(); j++) {
                    sb.append(' ');
                }
                sb.append((double)sundae.getCost() / 100);
            }

            if (list.get(i).getClass() == Candy.class) {
                Candy candy = (Candy)list.get(i);
                sb.append("\n" + candy.getWeight() + "lbs. @ " + candy.getPricePerPound() + "/lb.");
                sb.append("\n" + candy.name);
                for (int j = 0; j < 28 - candy.name.length(); j++) {
                    sb.append(' ');
                }
                sb.append((double)candy.getCost() / 100);
            }

            if (list.get(i).getClass() == Cookie.class) {
                Cookie cookie = (Cookie) list.get(i);
                sb.append("\n" + cookie.getNumber() + " @ " + cookie.getPricePerDozen() + " /dz.");
                sb.append("\n" + cookie.name);
                for (int j = 0; j < 28 - cookie.name.length(); j++) {
                    sb.append(' ');
                }
                sb.append((double)cookie.getCost() / 100);
            }
        }
        sb.append("\n\nTax");
        for (int j = 0; j < 25; j++) {
            sb.append(' ');
        }
        sb.append(trimLeading0((double)totalTax() / 100));
        sb.append("\nTotal Cost");
        for (int j = 0; j < 18; j++) {
            sb.append(' ');
        }
        sb.append((double)(totalCost() + totalTax()) / 100);
        return sb.toString();
    }

    private String trimLeading0(double value) {
        String res = Double.toString(value);

        if (value < 1) {
            res = res.substring(1);
        }

        return res;
    }
}