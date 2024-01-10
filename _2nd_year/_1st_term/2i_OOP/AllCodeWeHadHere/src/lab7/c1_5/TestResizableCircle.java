package lab7.c1_5;

public class TestResizableCircle {
    public static void main(String[] args) {
        ResizableCircle r1 = new ResizableCircle(97);
        System.out.println(r1);
        r1.resize(97);
        System.out.println("After resize we have: ");
        System.out.println(r1);
    }
}
