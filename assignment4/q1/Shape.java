package assignment4.q1;

public class Shape {
    private final String name;
    private double perimeter;
    private double area;

    public Shape() {
        this("Shape");
    }

    public Shape(String name) {
        this.name = name;
    }

    public Shape(String name, double perimeter, double area) {
        this.name = name;
        this.perimeter = perimeter;
        this.area = area;
    }

    public void draw() {
        System.out.println("Drawing " + name);
    }

    public double getArea() {
        System.out.println(area);
        return area;
    }

    public double getPerimeter() {
        System.out.println(perimeter);
        return perimeter;
    }

    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    protected void setArea(double area) {
        this.area = area;
    }
}
