package lab4;

public class GCDRecursive {
    public static int gcd(int a, int b){
        if (b == 0){
            if (a > 0){
                return a;
            } else {
                return -a;
            }
        }
        return gcd(b, remainder(a, b));
    }

    private static int remainder(int a, int b){
        return a % b;
    }

    public static void main(String[] args) {
        int a1 = 6;     int b1 = 0;
        int a2 = 9;     int b2 = 5;
        int a3 = 0;     int b3 = 4;
        int a4 = 90;    int b4 = 88;
        int a5 = -8;    int b5 = 6;
        System.out.println(gcd(a1, b1));
        System.out.println(gcd(a2, b2));
        System.out.println(gcd(a3, b3));
        System.out.println(gcd(a4, b4));
        System.out.println(gcd(a5, b5));
    }
}
