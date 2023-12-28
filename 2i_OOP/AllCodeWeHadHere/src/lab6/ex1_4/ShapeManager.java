package lab6.ex1_4;

public class ShapeManager {
    private int capability;
    private Shape[] shapes;
    private int availableIndex;

    public ShapeManager() {
        this.capability = 10;
        shapes = new Shape[this.capability];
        availableIndex = 0;
    }

    public void add(Shape shape) {
        shapes[availableIndex] = shape;
        availableIndex++;
    }

    public Circle[] filterCircle() {
        Circle[] circles = new Circle[this.shapes.length];
        int appendIndex = 0;
        for (int i = 0; i < availableIndex; i++) {
            if (shapes[i] instanceof Circle) {
                circles[appendIndex] = (Circle) shapes[i];
                appendIndex++;
            }
        }
        return circles;
    }

    public void printArea() {
        for (int i = 0; i < availableIndex; i++) {
            if (shapes[i] instanceof Circle){
                System.out.println( ((Circle)shapes[i]).getArea());
            } else if (shapes[i] instanceof Rectangle){
                System.out.println( ((Rectangle)shapes[i]).getArea());
            }
        }
    }

    public void printPerimeter() {
        for (int i = 0; i < availableIndex; i++) {
            if (shapes[i] instanceof Circle){
                System.out.println( ((Circle)shapes[i]).getPerimeter());
            } else if (shapes[i] instanceof Rectangle){
                System.out.println( ((Rectangle)shapes[i]).getPerimeter());
            }
        }
    }

    public static void main(String[] args) {
        ShapeManager shapeManager = new ShapeManager();

        Circle shape1 = new Circle();
        shapeManager.add(shape1);

        Rectangle shape2 = new Rectangle();
        shapeManager.add(shape2);

        System.out.println("Area of Circle and Rectangle: ");
        shapeManager.printArea();

        System.out.println("Perimeter of Circle and Rectangle");
        shapeManager.printPerimeter();
    }
}
