package lab5.b2c6denb2c10;

public class MyPoint {
    private int x = 0;
    private int y = 0;

    public MyPoint(){}

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getXY(){
        int[] output = new int[2];
        output[0] = this.x;
        output[1] = this.y;
        return output;
    }

    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "(" + this.x + ", " + this.y + ")";
    }

    public double distance(int x, int y){
        //Distance from this point to (x,y)
        return Math.sqrt((this.x - x) * (this.x - x) +
                (this.y - y) * (this.y - y));
    }

    public double distance(MyPoint another){
        //Distance from this point to another
        return Math.sqrt((this.x - another.getX()) * (this.x - another.getX()) +
                (this.y - another.getY()) * (this.y - another.getY()));
    }

    public double distance(){
        //Distance from this point to (0,0)
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }
}
