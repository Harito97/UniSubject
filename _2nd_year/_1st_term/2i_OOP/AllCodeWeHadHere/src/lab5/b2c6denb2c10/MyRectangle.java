package lab5.b2c6denb2c10;

public class MyRectangle {
    private MyPoint topLeft;
    private MyPoint botRight;

    public MyRectangle(int x1, int y1, int x2, int y2) {
        topLeft = new MyPoint();
        botRight = new MyPoint();
        topLeft.setXY(x1, y1);
        botRight.setXY(x2, y2);
    }

    public MyRectangle(MyPoint topLeft, MyPoint botRight) {
        this.topLeft = topLeft;
        this.botRight = botRight;
    }

    public MyPoint getTopRight() {
        return new MyPoint(botRight.getX(), topLeft.getY());
    }

    public MyPoint getBotLeft() {
        return new MyPoint(topLeft.getX(), botRight.getY());
    }

    @Override
    public String toString() {
        return "MyRectangle[" + "topLeft=" + topLeft.toString() + ", topRight=" + getTopRight().toString() + ", botRight=" + botRight.toString() + ", topLeft=" + getBotLeft().toString() + ']';
    }

    public double getArea() {
        return topLeft.distance(getTopRight()) * botRight.distance(getTopRight());
    }

    public double getPerimeter() {
        return 2.0 * (topLeft.distance(getTopRight()) + botRight.distance(getTopRight()));
    }

    public MyPoint getCenter() {
        return new MyPoint((topLeft.getX() + botRight.getX()) / 2, (topLeft.getY() + botRight.getY()) / 2);
    }
}
