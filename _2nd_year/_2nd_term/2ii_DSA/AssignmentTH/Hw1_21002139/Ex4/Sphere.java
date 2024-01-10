package DataStructureAndAlgorithms.AssignmentTH.Hw1_21002139.Ex4;

public class Sphere {
    private double radius = 0;                      //ban kinh
    private double[] coordinates = new double[3];   //toa do 3D (x,y,z)

    public Sphere(double radius, double[] coordinates) {
        this.radius = radius;
        this.coordinates = coordinates;
    }
    public Sphere(double radius, double x, double y, double z) {
        this.radius = radius;
        coordinates[0] = x;
        coordinates[1] = y;
        coordinates[2] = z;
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double[] getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }
    public void setX(double x) {
        coordinates[0] = x;
    }
    public double getX() {
        return coordinates[0];
    }
    public void setY(double x) {
        coordinates[1] = x;
    }
    public double getY() {
        return coordinates[1];
    }
    public void setZ(double x) {
        coordinates[2] = x;
    }
    public double getZ() {
        return coordinates[2];
    }
    
    //Interface
    //Calculate Square
    public double square() {
        return 4 * Math.PI * radius * radius;
    }

    //Calculate Volume
    public double volume() {
        return 4/3 * Math.PI * radius * radius * radius;
    }

    //Identify 2 Sphere is intersect or is not intersect
    //If 2 Sphere is intersect then are they contain each other
    public void relationship(Sphere anotSphere) {
        if (isIntersect(anotSphere)) {
            System.out.println("2 Sphere are intersect");
            if (isContain(anotSphere)) {
                System.out.println("And this sphere contain the other");
            } else if (isContained(anotSphere)) {
                System.out.println("And this sphere is contained by the other");
            } else {
                System.out.println("And no sphere contain the other");
            }
        } else {
            System.out.println("2 Sphere are not intersect");
        }
    }

    //Distance of 2 Sphere (from its center)
    public double distance(Sphere anotSphere) {
        double result = (this.getX() - anotSphere.getX()) * (this.getX() - anotSphere.getX()) +
                        (this.getY() - anotSphere.getY()) * (this.getY() - anotSphere.getY()) +
                        (this.getZ() - anotSphere.getZ()) * (this.getZ() - anotSphere.getZ());
        return Math.sqrt(result);
    }

    //Is 2 Sphere intersect
    public boolean isIntersect(Sphere anotSphere) {
        return distance(anotSphere) <= this.getRadius() + anotSphere.getRadius();
    }

    //Is this Sphere contain the other Sphere
    public boolean isContain(Sphere anotSphere) {
        return this.getRadius() >= distance(anotSphere) + anotSphere.getRadius();
    }

    //Is this Sphere be contained by the other Sphere
    public boolean isContained(Sphere anotSphere) {
        return this.getRadius() + distance(anotSphere) <= anotSphere.getRadius();
    }

    public static void main(String[] args) {
        Sphere firstSphere = new Sphere(9, 0, 0, 0);
        System.out.println("Square of firstSphere: " + firstSphere.square());
        System.out.println("Volume of firstSphere: " + firstSphere.volume());

        double[] randomCoordinate = new double[] {10 * Math.random(), 10 * Math.random(), 10 * Math.random()};
        Sphere secondSphere = new Sphere(1, randomCoordinate);

        firstSphere.relationship(secondSphere);
    }
}