package oop_exersises_for_final_examination;

public class TestCircle2 {
    public static void main(String[] args) {
        // Declare an instance of Circle2 class called c1.
        // Construct the instance c1 by invoking the "default" constructor
        // which sets its radius to their default value.
        Circle2 c1 = new Circle2();
        // Invoke public methods on instance c1, via dot operator.
        System.out.println("The circle has radius of "
                + c1.getRadius() + ", circumference of "
                + c1.getCircumference() + " and area of "
                + c1.getArea());
        //The circle has radius of 1.0 and area of 3.141592653589793
        // Declare an instance of class Circle2 called c2.
        // Construct the instance c2 by invoking the second constructor
        // with the given radius.
        Circle2 c2 = new Circle2(2.0);
        // Invoke public methods on instance c2, via dot operator.

        System.out.println("The circle has radius of "
                + c2.getRadius() + ", circumference of "
                + c2.getCircumference() + " and area of "
                + c2.getArea());
        //The circle has radius of 2.0 and area of 12.566370614359172
    }
}
