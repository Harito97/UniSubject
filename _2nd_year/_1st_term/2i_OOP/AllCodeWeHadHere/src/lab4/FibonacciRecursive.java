package lab4;

public class FibonacciRecursive {
    public static int fibonacci(int n){
        if (n < 0){
            return -1;
        }
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n -2);
    }

    public static void main(String[] args) {
        int n = 0;
        int m = 16;
        int p = -8;
        System.out.println(fibonacci(n));
        System.out.println(fibonacci(m));
        System.out.println(fibonacci(p));
    }
}
