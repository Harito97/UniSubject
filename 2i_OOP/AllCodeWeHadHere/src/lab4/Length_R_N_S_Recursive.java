package lab4;

public class Length_R_N_S_Recursive {
    private static int numOfDigits(int n){
        int output = 1;
        while (n / 10 > 0){
            output++;
            n /= 10;
        }
        return output;
    }
    public static int lengthOfRNS(int n){
        if (n < 0){
            return -1;
        }
        if (n == 0 || n == 1){
            return 1;
        }
        return lengthOfRNS(n - 1) + numOfDigits(n);
    }

    public static void main(String[] args) {
        int n1 = 0;
        int n2 = -7;
        int n3 = 12;
        System.out.println(lengthOfRNS(n1));
        System.out.println(lengthOfRNS(n2));
        System.out.println(lengthOfRNS(n3));
    }
}
