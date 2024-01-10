package lab5.b2c6denb2c10;

import java.util.Arrays;

public class TestMyCircle {
    public static void main(String[] args) {
        MyPoint point1 = new MyPoint(1, 1);
        MyCircle circle1 = new MyCircle();
        MyCircle circle2 = new MyCircle(point1, 2);
        System.out.println(circle1);
        System.out.println(circle2);

        circle1.setRadius(3);
        circle1.setCenter(point1);
        System.out.println("center is: " + circle1.getCenter());
        System.out.println("radius is: " + circle1.getRadius());

        circle1.setCenterX(3);
        circle1.setCenterY(4);
        System.out.println("x center is: " + circle1.getCenterX());
        System.out.println("y center is: " + circle1.getCenterY());
        circle1.setCenterXY(4, 4);
        System.out.println("center is: " + Arrays.toString(circle1.getCenterXY()));

        System.out.println("area is: " + circle1.getArea());
        System.out.println("circumference is: " + circle1.getCircumference());
        circle1 = new MyCircle(new MyPoint(0, 0), 1);
        circle2 = new MyCircle(new MyPoint(2, 2), 1);
        System.out.println("distance is: " + circle1.distance(circle2));
    }
}
