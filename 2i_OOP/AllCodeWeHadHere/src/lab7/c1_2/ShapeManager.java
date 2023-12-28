package lab7.c1_2;

public class ShapeManager {
    public static void main(String[] args) {
        Circle c1 = new Circle(8);
        System.out.println(c1);
        System.out.println("Area = " + c1.getArea());
        System.out.println("Perimeter = " + c1.getPerimeter());

        Rectangle r1 = new Rectangle(7,9);
        System.out.println(r1);
        System.out.println("Area = " + r1.getArea());
        System.out.println("Perimeter = " + r1.getPerimeter());
    }
}
