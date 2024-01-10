package lab6.ex2_1;

import lab6.ex1_5.Mammal;

public class Line {
    private Point begin;
    private Point end;

    public Line(Point begin, Point end){
        this.begin = begin;
        this.end = end;
    }

    public Line(int beginX, int beginY, int endX, int endY){
        begin = new Point(beginX, endX);
        end = new Point(beginY, endY);
    }

    @Override
    public String toString() {
        return "Line[Begin[" + begin.toString() +
                "], End[" + end.toString() + "]]";
    }

    public Point getBegin(){
        return this.begin;
    }

    public Point getEnd(){
        return this.end;
    }

    public void setBegin(Point begin) {
        this.begin = begin;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public int getBeginX(){
        return begin.getX();
    }

    public int getBeginY(){
        return begin.getY();
    }

    public int getEndX(){
        return end.getX();
    }

    public int getEndY(){
        return end.getY();
    }

    public void setBeginX(int x){
        begin.setX(x);
    }

    public void setBeginY(int y){
        begin.setY(y);
    }

    public void setBeginXY(int x, int y){
        begin.setX(x);
        begin.setY(y);
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
        int xDelta = end.getX()  - begin.getX();
        int yDelta = end.getY() - begin.getY();
        return Math.sqrt(xDelta * xDelta
                        + yDelta * yDelta);
    }

    public double getGradient(){
        int xDelta = end.getX()  - begin.getX();
        int yDelta = end.getY() - begin.getY();
        return Math.atan2(yDelta, xDelta);
    }
}
