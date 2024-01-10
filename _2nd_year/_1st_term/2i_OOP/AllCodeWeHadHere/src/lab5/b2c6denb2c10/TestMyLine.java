package lab5.b2c6denb2c10;

import java.util.Arrays;

public class TestMyLine {
    public static void main(String[] args) {
        MyLine l1 = new MyLine(1, 1, 2, 2);
        System.out.println(l1);
        MyPoint p1 = new MyPoint(0, 0);
        MyPoint p2 = new MyPoint(3, 3);
        MyLine l2 = new MyLine(p1, p2);
        System.out.println(l2);

        System.out.println("begin is: " + l1.getBegin());
        System.out.println("end is: " + l1.getEnd());
        l1.setBegin(p1);
        l1.setEnd(p2);
        System.out.println(l1);

        System.out.println("x begin is: " + l1.getBeginX());
        System.out.println("x end is: " + l1.getEndX());
        System.out.println("y begin is: " + l1.getBeginY());
        System.out.println("y end is: " + l1.getEndY());
        l1.setBeginX(2);
        l1.setBeginY(2);
        l1.setEndX(5);
        l1.setEndY(5);
        System.out.println("x begin is: " + l1.getBeginX());
        System.out.println("x end is: " + l1.getEndX());
        System.out.println("y begin is: " + l1.getBeginY());
        System.out.println("y end is: " + l1.getEndY());

        l1.setBeginXY(1, 2);
        l1.setEndXY(3, 4);
        System.out.println("begin is: " + Arrays.toString(l1.getBeginXY()));
        System.out.println("end is: " + Arrays.toString(l1.getEndXY()));

        System.out.println("length is: " + l1.getLength());
        System.out.println("gradient is: " + l1.getGradient());
    }
}
