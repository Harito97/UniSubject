package lab3;

public class TribonacciInt {
    public static void main(String[] args) {
        final int TRIBONACCI_INT_MAX = Integer.MAX_VALUE;
        int fn_3 = 1;
        int fn_2 = 1;
        int fn_1 = 1;
        int idx = 3;
        int fn = fn_1 + fn_2 + fn_3;;
        System.out.println("F(" + 0 + ") = " + fn_3);
        System.out.println("F(" + 1 + ") = " + fn_2);
        System.out.println("F(" + 2 + ") = " + fn_1);
        while (TRIBONACCI_INT_MAX - fn_2 > fn_1) {
            //because when fn_1
            // -> int max => fn_2 & fn_3 -> int max too
            // => we should use int max - fn_2 > fn_1 to solve the overflow
            System.out.println("F(" + idx + ") = " + fn);
            fn_3 = fn_2;
            fn_2 = fn_1;
            fn_1 = fn;
            fn = fn_1 + fn_2 + fn_3;
            idx++;
        }
        System.out.println("F(" + idx + ") is out of range");
    }
}
