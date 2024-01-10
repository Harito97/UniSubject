package lab5.b2c6denb2c10;

public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    public MyTriangle(int x1, int y1,
                      int x2, int y2,
                      int x3, int y3){
        this.v1.setXY(x1, y1);
        this.v2.setXY(x2, y2);
        this.v3.setXY(x3, y3);
    }

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3){
        this.v1.setXY(v1.getX(), v1.getY());
        this.v2.setXY(v2.getX(), v2.getY());
        this.v3.setXY(v3.getX(), v3.getY());
    }

    public String toString(){
        return "MyTriangle[v1 = " + v1.toString() +
                ", v2 = " + v2.toString() +
                ", v3 = " + v3.toString() + "]";
    }

    public double getPerimeter(){
        double v1v2 = v1.distance(v2);
        double v2v3 = v2.distance(v3);
        double v3v1 = v3.distance(v1);
        return v1v2 + v2v3 + v3v1;
    }

    public String getType(){
        double v1v2 = v1.distance(v2);
        double v2v3 = v2.distance(v3);
        double v3v1 = v3.distance(v1);

        if (v1v2 == v2v3 && v2v3 == v3v1){
            return "equilateral";   //tam giac deu
        } else if (v1v2 == v2v3 || v2v3 == v3v1 || v3v1 == v1v2){
            return "isoseles";  //tam giac can
        } else {
            return "scalene";   //kich thuoc 3 cach khac nhau
        }
    }
}
