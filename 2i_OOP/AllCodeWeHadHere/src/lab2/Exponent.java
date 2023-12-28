package lab2;

import java.util.Scanner;

public class Exponent {
    public static int exponent(int base, int exp){
        int result = 1;
        for (int initialization = 1; initialization <= exp; initialization++){
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        //Declare variables
        int exp;
        int base;
        Scanner sc = new Scanner(System.in);

        //Prompt and read input
        System.out.print("Enter the base: ");
        base = sc.nextInt();
        System.out.print("Enter the exponent: ");
        exp = sc.nextInt();

        //Print result
        System.out.print(base + "raises to the power of " + exp + " is: "
                + exponent(base, exp) );
    }
}
