package lab7.c1_4;

public class TestMovableCircle {
    public static void main(String[] args) {
        MovableCircle c1 = new MovableCircle(1,2,3,4,10);
        System.out.println(c1);
        c1.moveUp();
        System.out.println(c1);
        c1.moveDown();
        System.out.println(c1);
        c1.moveLeft();
        System.out.println(c1);
        c1.moveRight();
        System.out.println(c1);
    }
}
