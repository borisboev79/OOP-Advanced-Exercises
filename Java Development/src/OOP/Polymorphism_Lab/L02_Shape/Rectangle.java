package OOP.Polymorphism_Lab.L02_Shape;

public class Rectangle extends Shape{
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.setHeight(height);
        this.setWidth(width);
        this.calculatePerimeter();
        this.calculateArea();
    }

    protected void setHeight(Double height){
        this.height = height;
    }
    public Double getHeight() {
        return height;
    }

    protected void setWidth(Double width) {
        this.width = width;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(2 * (this.height + this.width));
    }

    @Override
    protected void calculateArea() {
        setArea(this.height * this.width);
    }
}
