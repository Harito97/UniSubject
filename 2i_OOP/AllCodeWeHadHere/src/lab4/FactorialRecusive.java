package lab4;

public class FactorialRecusive {
    public static int factorial(int n){
        if (n < 0){
            return -1;
        } else if (n == 0){
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.printf("%nFactorial(" + n + ") is: " + factorial(n));
    }
}
