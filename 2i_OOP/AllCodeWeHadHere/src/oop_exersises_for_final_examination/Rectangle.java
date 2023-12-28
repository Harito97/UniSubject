package oop_exersises_for_final_examination;
//This is the exercise 1.3 in the OOP Exercises For Final Examination in week 3 of anh tro giang
public class Rectangle {
    //Properties
    private float length = 1.0f;
    private float width = 1.0f;

    //Constructor
    public Rectangle(){}
    public Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }

    //Methods
    public float getLength() {
        return length;
    }
    public void setLength(float length) {
        this.length = length;
    }
    public float getWidth() {
        return width;
    }
    public void setWidth(float width) {
        this.width = width;
    }

    public double getArea(){
        return this.length * this.width;
    }
    public double getPerimeter(){
        return 2 * (this.length + this.width);
    }

    public String toString(){
        return "Rectangle [length = " + this.length
                + ", width = " + this.width + "]";
    }
}
