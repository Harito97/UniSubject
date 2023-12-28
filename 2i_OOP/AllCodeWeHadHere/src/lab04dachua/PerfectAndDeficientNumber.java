import java.util.Scanner;

public class PerfectAndDeficientNumber {
    public static boolean isPerfect(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum == n;
    }

    public static boolean isDeficient(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum < n;
    }

    public static void main(String[] args) {
//        System.out.println(isDeficient(10));
//        System.out.println(isDeficient(12));
//        System.out.println(isPerfect(6));
//        System.out.println(isPerfect(10));
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the upper bound: ");
        int n = in.nextInt();
        System.out.println("These numbers are perfect:");
        int count = 0;
        for (int i = 6; i <= n; i++) {
            if (isPerfect(i)) {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.printf("\n%d perfect numbers found (%.2f%c)", count, (double) count / n * 100, '%');
    }
}
