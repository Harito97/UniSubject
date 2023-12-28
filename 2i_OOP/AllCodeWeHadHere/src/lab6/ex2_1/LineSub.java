package lab6.ex2_1;

public class LineSub extends Point{
    //private Point begin;
    private Point end;

    public LineSub(Point begin, Point end){
        super(begin.getX(), begin.getY());
        this.end = end;
    }

    public LineSub(int beginX, int beginY, int endX, int endY){
        super(beginX, beginY);
        end = new Point(beginY, endY);
    }

    @Override
    public String toString() {
        return "Line[Begin[" + super.toString() +
                "], End[" + end.toString() + "]]";
    }

    public Point getBegin(){
        return new Point(getX(), getY());
    }

    public Point getEnd(){
        return this.end;
    }

    public void setBegin(Point begin) {
        setXY(begin.getX(), begin.getY());
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public int getBeginX(){
        return getX();
    }

    public int getBeginY(){
        return getY();
    }

    public int getEndX(){
        return end.getX();
    }

    public int getEndY(){
        return end.getY();
    }

    public void setBeginX(int x){
        setX(x);
    }

    public void setBeginY(int y){
        setY(y);
    }

    public void setBeginXY(int x, int y){
        setX(x);
        setY(y);
    }

    public void setEndX(int x){
        end.setX(x);
    }

    public void setEndY(int y){
        end.setY(y);
    }

    public void setEndXY(int x, int y){
        end.setX(x);
        end.setY(y);
    }

    public double getLength(){
        int xDelta = end.getX()  - getX();
        int yDelta = end.getY() - getY();
        return Math.sqrt(xDelta * xDelta
                + yDelta * yDelta);
    }

    public double getGradient(){
        int xDelta = end.getX()  - getX();
        int yDelta = end.getY() - getY();
        return Math.atan2(yDelta, xDelta);
    }
}
