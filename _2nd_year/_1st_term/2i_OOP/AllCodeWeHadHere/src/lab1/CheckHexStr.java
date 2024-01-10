package lab1;

import java.util.Scanner;

public class CheckHexStr {
    public static void main(String[] args) {
        //Declare variables
        String input;
        int inputLength;
        Scanner in = new Scanner(System.in);
        boolean test = true;

        //Get input
        System.out.print("Enter a hex string: ");
        input = in.next();
        inputLength = input.length();

        //Process input
        for (int index = 0; index < inputLength; index++){
            char temp = input.charAt(index);
            if ( !( (temp >= '0' && temp <= '9') || (temp >= 'A' && temp <= 'F')
                    || (temp >= 'a' && temp <= 'f') ) ){
                test = false;
            }
        }

        //Print result
        if (test){
            System.out.print(input + " is a hex string");
        } else {
            System.out.print(input + " is NOT a hex string");
        }
    }
}
