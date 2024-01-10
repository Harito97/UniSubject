package lab1;

import java.util.Scanner;

public class Bin2Dec {
    public static void main(String[] args) {
        //Declare variables
        String input;
        int inputLength;
        Scanner in = new Scanner(System.in);
        boolean test = true;

        //Get input
        System.out.print("Enter a Binary string: ");
        input = in.next();
        inputLength = input.length();

        //Process input
        for (int index = 0; index < inputLength; index++){
            char temp = input.charAt(index);
            if ( !(temp >= '0' && temp <= '1') ){
                test = false;
            }
        }

        //Print result
        if (test){
            System.out.print("The equivalent decimal number for binary \"" + input + "\" is: "
                    + Integer.parseInt(input,2));
            //use method parseInt(numBinary, 2 vs 2 is Binary) to print the number in decimal
        } else {
            System.out.print("error: invalid binary string \"" + input + "\"");
        }
    }
}
