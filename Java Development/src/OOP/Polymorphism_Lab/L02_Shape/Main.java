package OOP.Polymorphism_Lab.L02_Shape;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(4.0);
        Shape rectangle = new Rectangle(2.0, 4.0);

       System.out.printf("%.2f%n", circle.getArea());
       System.out.printf("%.2f%n", circle.getPerimeter());
        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());
    }
}
