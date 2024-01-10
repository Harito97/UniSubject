package lab1;

import java.util.Scanner;

public class Oct2Dec {
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
        //Test input is a octal (0,1,2,.,,5,6,7) or not
        for (int index = 0; index < inputLength; index++){
            char temp = input.charAt(index);
            if ( !(temp >= '0' && temp <= '7') ){
                test = false;
            }
        }

        //Print result
        if (test){
            System.out.print("The equivalent decimal number for Octal \"" + input + "\" is: "
                    + Integer.parseInt(input,8));
            //use method parseInt(numOctal, 8 vs 8 is octal) to print the number in decimal
        } else {
            System.out.print("error: invalid octal string \"" + input + "\"");
        }
    }
}
