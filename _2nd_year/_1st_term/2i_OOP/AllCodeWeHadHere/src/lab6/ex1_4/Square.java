package lab6.ex1_4;

public class Square extends Rectangle{
    public Square(){}

    public Square(double side){
        super(side,side);
    }

    public Square(double side, String color, boolean filled){
        super(color, filled, side, side);
    }

    public double getSide(){
        return getLength();
    }

    public void setSide(double side){
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setWidth(double side){
        setSide(side);
    }
    @Override
    public void setLength(double side){
        setSide(side);
    }

    @Override
    public String toString() {
        return "Square[" +
                super.toString() + "]";
    }
}
