package assignment4.q1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
        setPerimeter(calculatePerimeter(radius));
        setArea(calculateArea(radius));
    }

    private double calculatePerimeter(double radius){
        double perimeter = 2 * Math.PI * radius;
        BigDecimal bd = new BigDecimal(Double.toString(perimeter));
        return bd.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    private double calculateArea(double radius){
        double area = Math.PI * radius * radius;
        BigDecimal bd = new BigDecimal(Double.toString(area));
        return bd.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }


}
