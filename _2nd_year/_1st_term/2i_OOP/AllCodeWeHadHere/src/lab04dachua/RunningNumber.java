public class RunningNumber {
    public static String runningNumber(int n) {
        if (n == 1) {
            return "1";
        }
        return runningNumber(n - 1) + n;
    }

    public static int len(int n) {
        if (n == 1) {
            return 1;
        }
        return len(n - 1) + (n + "").length();
    }

    public static void main(String[] args) {
        System.out.println(runningNumber(13));
        System.out.println(len(12));
    }
}
