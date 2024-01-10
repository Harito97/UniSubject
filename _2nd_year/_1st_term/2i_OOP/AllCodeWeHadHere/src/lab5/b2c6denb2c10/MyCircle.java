package lab5.b2c6denb2c10;

public class MyCircle {
    private MyPoint center = new MyPoint(0,0);
    private int radius = 1;

    public MyCircle(){}

    public MyCircle(int x, int y, int radius){
        this.center.setXY(x, y);
        this.radius = radius;
    }

    public MyCircle(MyPoint center, int radius){
        this.center.setXY(center.getX(), center.getY());
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public MyPoint getCenter(){
        return this.center;
    }

    public void setCenter(MyPoint center){
        this.center.setXY(center.getX(), center.getY());
    }

    public int getCenterX(){
        return this.center.getX();
    }

    public int getCenterY(){
        return this.center.getY();
    }

    public int[] getCenterXY(){
        return this.center.getXY();
    }

    public void setCenterX(int x){
        this.center.setX(x);
    }

    public void setCenterY(int y){
        this.center.setY(y);
    }

    public void setCenterXY(int x, int y){
        this.center.setXY(x, y);
    }

    public String toString(){
        return "MyCircle[radius = " + radius +
                ", center = " + this.center.toString() + "]";
    }

    public double getArea(){
        return Math.PI * this.radius * this.radius;
    }

    public double getCircumference(){
        return Math.PI * 2 * this.radius;
    }

    public double distance(MyCircle another){
        return this.center.distance(another.getCenter());
    }
}
