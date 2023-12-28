package lab3;

public class FactorialLong {
    public static void main(String[] args) {
        final long FACTORIAL_MAX = Long.MAX_VALUE;
        int idx = 1;
        long factorial = 1;
        do {
            System.out.println("The factorial of " + idx + " is " + factorial);
            factorial *= idx;
            idx++;
        } while (FACTORIAL_MAX / factorial > (idx + 1));
        System.out.println("The factorial of " + idx + " is out of range");
    }
}
