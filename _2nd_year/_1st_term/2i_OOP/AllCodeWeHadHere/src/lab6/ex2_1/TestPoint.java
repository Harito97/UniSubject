package lab6.ex2_1;

public class TestPoint {
    public static void main(String[] args) {
        Point p1 = new Point(10, 20);
        System.out.println("p1 is one point of us: ");
        System.out.println(p1);
        p1.setXY(100, 10);
        System.out.println("After using setter to change p1: ");
        System.out.println(p1);
        System.out.println("Using getter to take y value of p1: ");
        System.out.println(p1.getY());
    }
}
