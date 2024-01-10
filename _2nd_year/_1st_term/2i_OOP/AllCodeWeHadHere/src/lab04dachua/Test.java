public class Test {
    public static void print(int n) {
        System.out.print(n + " ");
        if (n <= 1) {
            return;
        }
        print(n - 1);
    }

    public static void main(String[] args) {
        print(10);
    }
}
