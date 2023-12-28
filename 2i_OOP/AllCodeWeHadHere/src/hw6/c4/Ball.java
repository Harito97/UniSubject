package hw6.c4;

public class Ball {
    //Attributes
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    //Constructor
    public Ball (float x, float y, int radius, int speed, int direction){
        if (radius > 0){
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.xDelta += speed * direction;
            this.yDelta += speed * direction;
        } else {
            System.out.print("\nCan't crete that ball.");
        }
    }

    //Getters, Setters
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getxDelta() {
        return xDelta;
    }

    public void setxDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getyDelta() {
        return yDelta;
    }

    public void setyDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    //APIs
    public void move(){
        x += xDelta;
        y += yDelta;
    }

    public void reflectHorizontal(){
        xDelta *= -1;
    }

    public void reflectVertical(){
        yDelta *= -1;
    }

    public String toString(){
        String ouput = "Ball[(" + x + "," + y +
                "),speech=(" + xDelta + "," + yDelta + ")]";
        return ouput;
    }

}
