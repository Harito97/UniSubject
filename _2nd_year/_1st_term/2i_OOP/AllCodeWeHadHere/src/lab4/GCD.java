package lab4;

public class GCD {
    //Use Euclid algorithm
    public static int gcd(int a, int b) {
        if (b == 0) {
            if (a > 0){
                return a;
            } else {
                return -a;
            }

        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(7, 9));
        System.out.println(gcd(90, 9));
        System.out.println(gcd(-8, 6));
    }
}
