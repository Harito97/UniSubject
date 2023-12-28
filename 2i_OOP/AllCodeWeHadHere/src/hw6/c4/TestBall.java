package hw6.c4;

public class TestBall {
    public static void main(String[] args) {
        System.out.print("Ball a:");
        Ball a = new Ball(1.00f, 2.16f, -5, -9, -6);
        System.out.println("\nBall b:");
        Ball b = new Ball(1.00f, 2.16f, 5, -9, -6);
        System.out.println(b.toString());
        System.out.println("Move ball b:");
        b.move();
        System.out.println(b.toString());
        System.out.println("Reflect Horizontal ball b:");
        b.reflectHorizontal();
        System.out.println(b.toString());
        System.out.println("Reflect Vertical ball b:");
        b.reflectVertical();
        System.out.println(b.toString());
    }
}
