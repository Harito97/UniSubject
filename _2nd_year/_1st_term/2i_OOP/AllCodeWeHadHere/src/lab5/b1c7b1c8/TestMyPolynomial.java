package lab5.b1c7b1c8;

public class TestMyPolynomial {
    public static void main(String[] args) {
        MyPolynomial p1 = new MyPolynomial(1.1,2.2,3.3,4.4,5.5);
        double[] coeffs = {1.2, 3.4, 5.6, 7.8, 5.4};
        MyPolynomial p2 = new MyPolynomial(coeffs);

        System.out.println("Here is p1 and p2");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println("p1's degree: ");
        System.out.println(p1.getDegree());
        System.out.println("Value of p1 with x: ");
        System.out.printf("%.4f%n", p1.evaluate(5.3));
        System.out.println("p1 + p2 = ");
        System.out.println(p1.add(p2));
        System.out.println("p1 * p2 = ");
        System.out.println(p1.multiply(p2));
    }
}