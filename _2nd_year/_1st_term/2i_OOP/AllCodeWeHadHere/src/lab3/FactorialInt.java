package lab3;

public class FactorialInt {
    public static void main(String[] args) {
        final int FACTORIAL_MAX = Integer.MAX_VALUE;
        int idx = 1;
        int factorial = 1;
        do {
            System.out.println("The factorial of " + idx + " is " + factorial);
            factorial *= idx;
            idx++;
        } while (FACTORIAL_MAX / factorial > (idx + 1));
        System.out.println("The factorial of " + idx + " is out of range");
    }
}
