package lab6.ex1_3;

public class TestCase {
    public static void main(String[] args) {
        Point2D p2d = new Point2D();
        Point3D p3d = new Point3D();

        //Test toString()
        System.out.println(p2d);
        System.out.println(p3d);

        //Test getters, setters
        p3d.setXYZ(1.0f, 2.0f, 3.0f);
        System.out.println("p3d after change: ");
        System.out.println(p3d);
        float[] test = p3d.getXYZ();
        System.out.println("Using setters to take p3d information");
        for (int i = 0; i < test.length; i++){
            System.out.println(test[i]);
        }
    }

}
