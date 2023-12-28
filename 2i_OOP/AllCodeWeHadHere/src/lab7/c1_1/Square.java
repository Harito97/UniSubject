package lab7.c1_1;

public class Square extends Rectangle{
    public Square() {
    }

    public Square(double side){
        super(side, side);
    }

    public Square(double side, String color, boolean filled){
        super(side, side, color, filled);
    }

    public double getSide(){
        return super.length;
    }

    public void setSide(double side){
        length = side;
        width = side;
    }

    public void setWidth(double side){
        length = side;
        width = side;
    }

    public void setLength(double side){
        length = side;
        width = side;
    }

    @Override
    public String toString() {
        return "Square[" + super.toString() +
                ", width = " + width +
                ", length = " + length +
                ']';
    }
}
