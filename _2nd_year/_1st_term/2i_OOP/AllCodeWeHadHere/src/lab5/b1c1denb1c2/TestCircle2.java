package lab5.b1c1denb1c2;

public class TestCircle2 {
    public static void main(String[] args) {
        //Test Constructors and to String()
        Circle2 c1 = new Circle2(1.1);
        System.out.println(c1);     //Test toString()
        Circle2 c2 = new Circle2(); //default constructor
        System.out.println(c2);

        //Test setter and getter
        c1.setRadius(2.2);
        System.out.println(c1);
        System.out.println("radius is: " + c1.getRadius());

        //Test getArea() and getCircumference()
        System.out.printf("are is: %.2f%n", c1.getArea());
        System.out.printf("circumference is: %.2f%n", c1.getCircumference());

    }
}
