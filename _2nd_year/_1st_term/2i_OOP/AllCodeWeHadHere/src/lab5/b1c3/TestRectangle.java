package lab5.b1c3;

import lab5.b1c3.Rectangle;

public class TestRectangle {
    public static void main(String[] args) {
        //This is the second mainTest
        //Test constructors and toString()
        Rectangle r1 = new Rectangle(1.2f, 3.4f);
        System.out.println(r1);     //toString()
        Rectangle r2 = new Rectangle(); //default constructor
        System.out.println(r2);

        //Test setters and setters
        r1.setLength(5.6f);
        r1.setWidth(7.8f);
        System.out.println(r1);     //toString()
        System.out.println("length is: " + r1.getLength());
        System.out.println("width is: " + r1.getWidth());

        //Test getArea() and getPerimeter()
        System.out.printf("area is: %.2f%n", r1.getArea());
        System.out.printf("perimeter is: %.2f%n", r1.getPerimeter());

        //This is the first mainTest
//        //Create r1 with constructor 1 (size = default)
//        Rectangle r1 = new Rectangle();
//        //Create r2 with constructor 2 (size = user's choice)
//        Rectangle r2 = new Rectangle(5.0f, 2.0f);
//
//        System.out.println("Here is the information of r1: ");
//        System.out.printf(r1.toString() + "%nArea = " + r1.getArea()
//                            + "%nPerimeter = " + r1.getPerimeter());
//        System.out.printf("%n%n");
//        System.out.println("Here is the information of r2: ");
//        System.out.printf(r2.toString() + "%nArea = " + r2.getArea()
//                + "%nPerimeter = " + r2.getPerimeter());
    }
}
