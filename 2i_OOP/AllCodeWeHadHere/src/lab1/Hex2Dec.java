package lab1;

import java.util.Scanner;

public class Hex2Dec {
    public static void main(String[] args) {
        //Declare variables
        String input;
        int inputLength;
        Scanner in = new Scanner(System.in);
        boolean test = true;

        //Get input
        System.out.print("Enter a Hexadecimal string: ");
        input = in.next();
        inputLength = input.length();

        //Process input
        //Test input is a hexadecimal (0,1,2,.,9,A,B,C,D,E,F) or not
        for (int index = 0; index < inputLength; index++){
            char temp = input.charAt(index);
            if ( !( (temp >= '0' && temp <= '9') || (temp >= 'A' && temp <= 'F')
                    || (temp >= 'a' && temp <= 'f') ) ){
                test = false;
            }
        }

        //Print result
        if (test){
            System.out.print("The equivalent decimal number for hexadecimal \"" + input + "\" is: "
                    + Integer.parseInt(input,16));
            //use method parseInt(numHexa, 16 vs 16 is hexadecimal) to print the number in decimal
        } else {
            System.out.print("error: invalid hexadecimal string \"" + input + "\"");
        }
    }
}
