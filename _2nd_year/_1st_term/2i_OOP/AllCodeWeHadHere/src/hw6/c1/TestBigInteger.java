package hw6.c1;

import java.math.BigInteger;

public class TestBigInteger {
    public static void main(String[] args) {
        BigInteger i1 = new BigInteger("11111111111111111111111111111111111111111111111111111111111111");
        BigInteger i2 = new BigInteger("22222222222222222222222222222222222222222222222222");

        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
        System.out.println("i1 + i2 = " + i1.add(i2));
        System.out.println("Now i1 = " + i1);
        //=> i1 still not be change
        System.out.println("i1 * i2 = " + i1.multiply(i2));
        System.out.println("i1 - t2 = " + i1.subtract(i2));
        System.out.println("i1 / i2 = " + i1.divide(i2));
        System.out.println("gcd of i1 and i2: " + i1.gcd(i2));
        System.out.println("i2^2 = " + i2.pow(2));
        System.out.println("The attribute TEN of BigInteger: " + BigInteger.TEN);

    }
}
