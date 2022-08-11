package OOP.SOLID_Lab.p01_SingleResponsibility.p01_DrawingShape;

import OOP.SOLID_Lab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingRepository;
import OOP.SOLID_Lab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Renderer;
import OOP.SOLID_Lab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
       return this.height*this.width;
    }

    @Override
    public void draw(Renderer rengerer, DrawingRepository drawingRepository) {
        rengerer.render(drawingRepository,this);

    }
}
