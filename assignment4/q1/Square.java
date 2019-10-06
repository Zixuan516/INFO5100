package assignment4.q1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Square extends Shape {
    private final double side;

    public Square(double side) {
        super("Square");
        this.side = side;
        setPerimeter(calculatePerimeter(side));
        setArea(calculateArea(side));
    }

    private double calculatePerimeter(double side){
        double perimeter = 4 * side;
        BigDecimal bd = new BigDecimal(Double.toString(perimeter));
        return bd.setScale(1, RoundingMode.HALF_UP).doubleValue();
    }

    private double calculateArea(double side) {
        double area = side * side;
        BigDecimal bd = new BigDecimal(Double.toString(area));
        return bd.setScale(1, RoundingMode.HALF_UP).doubleValue();
    }
}
