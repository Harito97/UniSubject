package lab6.ex2_1;

public class TestLine {
    public static void main(String[] args) {
        Line l1 = new Line(0,0,3,4);
        System.out.println(l1);

        Point p1 = new Point(0, 5);
        Point p2 = new Point(9, 4);

        Line l2 = new Line(p1, p2);
        System.out.println(l2);

        System.out.println("Length of l1: ");
        System.out.println(l1.getLength());
        System.out.println("Gradiant of l2: ");
        System.out.println(l2.getGradient());
    }
}
