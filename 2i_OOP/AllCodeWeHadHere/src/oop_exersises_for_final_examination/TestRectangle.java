package oop_exersises_for_final_examination;

public class TestRectangle {
    public static void main(String[] args) {
        //Create r1 with constructor 1 (size = default)
        Rectangle r1 = new Rectangle();
        //Create r2 with constructor 2 (size = user's choice)
        Rectangle r2 = new Rectangle(5.0f, 2.0f);

        System.out.println("Here is the information of r1: ");
        System.out.printf(r1.toString() + "%nArea = " + r1.getArea()
                            + "%nPerimeter = " + r1.getPerimeter());
        System.out.printf("%n%n");
        System.out.println("Here is the information of r2: ");
        System.out.printf(r2.toString() + "%nArea = " + r2.getArea()
                + "%nPerimeter = " + r2.getPerimeter());
    }
}
