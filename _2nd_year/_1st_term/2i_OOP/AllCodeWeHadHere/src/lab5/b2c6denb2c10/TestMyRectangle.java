package lab5.b2c6denb2c10;

public class TestMyRectangle {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint(2, 2);
        MyPoint p2 = new MyPoint(1, 1);
        MyRectangle rectangle0 = new MyRectangle(1, 1, 2, 0);
        MyRectangle rectangle1 = new MyRectangle(p1, p2);
        System.out.println(rectangle0);
        System.out.println(rectangle1);

        System.out.println("top-right point is: " + rectangle1.getTopRight().toString());
        System.out.println("bottom-left point is: " + rectangle1.getBotLeft().toString());
        System.out.println("center-point is: " + rectangle1.getCenter().toString());
        System.out.println("area is: " + rectangle1.getArea());
        System.out.println("perimeter is: " + rectangle1.getPerimeter());
    }
}
