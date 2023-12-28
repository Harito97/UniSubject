package lab5.b1c1denb1c2;
//This is the exercise 1.2 in the OOP Exercises For Final Examination in week 3 of anh tro giang
public class Circle2 {
    //Property
    private double radius = 1.0;

    //Constructor
    public Circle2() {
    }
    public Circle2(double radius) {
        this.radius = radius;
    }

    //Method
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI * this.radius * this.radius;
    }
    public double getCircumference(){
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String toString() {
        return "Circle2[" +
                "radius=" + radius +
                ']';
    }
}
