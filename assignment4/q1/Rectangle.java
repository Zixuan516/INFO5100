package assignment4.q1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rectangle extends Shape {
    private final double width;
    private final double height;


    public Rectangle(double width, double height) {
        super("Rectangle");
        this.width = width;
        this.height = height;
        setPerimeter(calculatePerimeter(width, height));
        setArea(calculateArea(width, height));
    }

    private double calculatePerimeter(double width, double height){
        double perimeter = 2 * (width + height);
        BigDecimal bd = new BigDecimal(Double.toString(perimeter));
        return bd.setScale(1, RoundingMode.HALF_UP).doubleValue();
    }

    private double calculateArea(double width, double height){
        double area = width * height;
        BigDecimal bd = new BigDecimal(Double.toString(area));
        return bd.setScale(1, RoundingMode.HALF_UP).doubleValue();
    }
}
