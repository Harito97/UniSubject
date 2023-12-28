package lab5.b1c1denb1c2;
//This is the exercise 1.1 in the OOP Exercises For Final Examination in week 3 of anh tro giang
public class Circle1 {
    //Properties
    private double radius = 1.0;
    private String color = "red";

    //Constructors
    public Circle1(){               // 1st constructor
    }
    public Circle1(double r) {      // 2nd constructor
        this.radius = r;
        this.color = "red";
    }
    public Circle1(double r, String color){     // 3rd constructor
        this.radius = r;
        this.color = color;
    }

    //Method
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle1[" +
                "radius=" + radius +
                ", color='" + color +
                ']';
    }

    public double getArea(){
        return Math.PI * this.radius * this.radius;
    }
}
