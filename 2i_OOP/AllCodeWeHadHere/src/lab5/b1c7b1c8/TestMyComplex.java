package lab5.b1c7b1c8;

public class TestMyComplex {
    public static void main(String[] args) {
        MyComplex c1 = new MyComplex(2.3, 5.6);
        MyComplex c2 = new MyComplex();
        MyComplex c3 = new MyComplex(5.4, 8.7);

        System.out.println("c1, c2, c3 lan luot la: ");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        System.out.println("c1 co la real number khong: ");
        System.out.println(c1.isReal());
        System.out.println("c1 co la imaginary number khong: ");
        System.out.println(c1.isImaginary());

        System.out.println("c1 co bang c2 khong: ");
        System.out.println(c1.equals(c2));

        System.out.println("c2 += c3, now c2 here: ");
        c2.addInto(c3);
        System.out.println(c2);

        System.out.println("c1 -= c3, now c1 here: ");
        c1.subtractInto(c3);
        System.out.println(c1);

        System.out.println("c2 *= c3, now c2 here: ");
        c2.multiply(c3);
        System.out.println(c2);

        System.out.println("c1 /= c3, now c1 here: ");
        c1.divide(c3);
        System.out.println(c1);

        System.out.println("Magnitude of c3: ");
        System.out.printf("%.4f%n", c3.magnitude());

        System.out.println("Argument of c3: ");
        System.out.printf("%.4f", c3.argument());

        System.out.printf("%nConjugate of c3: %n");
        System.out.println(c3.conjugate());
    }
}
