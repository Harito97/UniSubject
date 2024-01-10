package lab4;

import java.util.Scanner;

public class PerfectNumberList {
    //A perfect number Eg: 6 = 1+2+3
    public static boolean isPerfect (int aPosInt){
        if (aPosInt <= 0){
            return false;
        }
        int sum = 0;
        for (int i = 1; i < aPosInt; i++){
            if (aPosInt % i == 0){
                sum += i;
            }
        }
        return sum == aPosInt;
    }

    //A deficient number Eg: 10 > 1+2+5
    public static boolean isDeficient(int aPosInt){
        if (aPosInt <= 0){
            return false;
        }
        int sum = 0;
        for (int i = 1; i < aPosInt; i++){
            if (aPosInt % i == 0){
                sum += i;
            }
        }
        return sum < aPosInt;
    }

    //Main
    public static void main(String[] args) {
        System.out.print("Enter the upper bound: ");
        int count = 0;
        Scanner sc = new Scanner(System.in);
        int upperBound = sc.nextInt();
        System.out.println("These number are perfect: ");
        for (int i = 1; i <= upperBound; i++){
            if (isPerfect(i)){
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.printf("%n[" + count + " perfect numbers found (");
        System.out.printf("%.2f%s", count * 100.0 / upperBound, "%)]");
        System.out.printf("%nThese numbers are neither deficient nor perfect:%n");
        count = 0;
        for (int i = 1; i <= upperBound; i++){
            if (!isPerfect(i) && !isDeficient(i)){
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.printf("%n[" + count + " numbers found (");
        System.out.printf("%.2f%s", count * 100.0 / upperBound, "%)]");    }
}
