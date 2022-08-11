package OOP.Polymorphism_Lab.L02_Shape;

public class Circle extends Shape{
    private Double radius;

    public Circle(Double radius) {
        this.setRadius(radius);
        this.calculatePerimeter();
        this.calculateArea();
    }

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(2 * this.radius * Math.PI);
    }

    @Override
    protected void calculateArea() {
        setArea(this.radius * this.radius * Math.PI);
    }
}


