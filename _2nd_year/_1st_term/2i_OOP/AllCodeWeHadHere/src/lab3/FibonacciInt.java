package lab3;

public class FibonacciInt {
    public static void main(String[] args) {
        final int FIBONACCI_INT_MAX = Integer.MAX_VALUE;
        int fn_2 = 1;
        int fn_1 = 2;
        int idx = 2;
        int fn = fn_1 + fn_2;;
        System.out.println("F(" + 0 + ") = " + fn_2);
        System.out.println("F(" + 1 + ") = " + fn_1);
        while (FIBONACCI_INT_MAX - fn_2 > fn_1) {
            System.out.println("F(" + idx + ") = " + fn);
            fn_2 = fn_1;
            fn_1 = fn;
            fn = fn_1 + fn_2;
            idx++;
        }
        System.out.println("F(" + idx + ") is out of range");
    }
}
