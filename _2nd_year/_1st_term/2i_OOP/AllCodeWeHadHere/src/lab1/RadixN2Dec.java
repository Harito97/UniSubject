package lab1;

import java.util.Scanner;

public class RadixN2Dec {
    //This program help user input a radix and a number for that radix.
    //Then it send the equivalent decimal number for the number with radix user inputted.

    public static void main(String[] args) {
        //Declare variables
        String input;
        int inputLength;
        int radix;
        Scanner in = new Scanner(System.in);
        boolean test = true;

        //Get input
        System.out.print("Enter the radix: ");
        radix = Integer.parseInt(in.next());
        System.out.print("Enter a number for radix = " + radix + ": ");
        input = in.next();
        inputLength = input.length();
        in.close();

        //Process input
        //Test input is a radix number (0,1,2,.,,5,6,...,radix - 1) or not
        //Suppose every number user inputted is a radix number

        //Print result
        if (test){
            System.out.print("The equivalent decimal number for radix = " + radix + " \"" + input + "\" is: "
                    + Integer.parseInt(input,radix));
            //use method parseInt(numOctal, radix vs radix is radix of the number inputted) to print the number in decimal
        } else {
            System.out.print("error: invalid " + radix + " number \"" + input + "\"");
        }
    }
}
