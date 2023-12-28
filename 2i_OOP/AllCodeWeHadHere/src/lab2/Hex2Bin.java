package lab2;

import java.util.Scanner;

public class Hex2Bin {
    public static void main(String[] args) {
        //Declare variables
        Scanner in = new Scanner(System.in);

        //Get input
        System.out.print("Enter a Hexadecimal string: ");
        String inStr = in.next();
        String input = inStr.toUpperCase();
        int inputLength = input.length();

        //Check input is a hexadecimal string or not
        boolean test = true;    //Flag to test
        for (int index = 0; index < inputLength; index++){
            char temp = input.charAt(index);
            if ( !( (temp >= '0' && temp <= '9') || (temp >= 'A' && temp <= 'F') ) ){
                test = false;
                break;
            }
        }
        while (!test){
            System.out.println("That's not a Hexadecimal string!");
            System.out.print("Enter again a Hexadecimal string: ");
            inStr = in.next();
            input = inStr.toUpperCase();
            inputLength = input.length();
            test = true;
            for (int index = 0; index < inputLength; index++){
                char temp = input.charAt(index);
                if ( !((temp >= '0' && temp <= '9') || (temp >= 'A' && temp <= 'F')) ){
                    test = false;
                    break;
                }
            }
        }
        in.close();

        //After user input correctly a Hexadecimal string
        //-> Process and print
        final  String[] HEX_BITS = {"0000", "0001", "0010", "0011",
                                    "0100", "0101", "0110", "0111",
                                    "1000", "1001", "1010", "1011",
                                    "1100", "1101", "1110", "1111"};
        System.out.print("The equivalent binary for hexadecimal \"" + inStr + "\" is : ");
        for (int index = 0; index < inputLength; index++){
            int temp = 0;       //temp will help find the index of binary in array
            switch (input.charAt(index)){
                case '0':
                    temp = 0;
                    break;
                case '1':
                    temp = 1;
                    break;
                case '2':
                    temp = 2;
                    break;
                case '3':
                    temp = 3;
                    break;
                case '4':
                    temp = 4;
                    break;
                case '5':
                    temp = 5;
                    break;
                case '6':
                    temp = 6;
                    break;
                case '7':
                    temp = 7;
                    break;
                case '8':
                    temp = 8;
                    break;
                case '9':
                    temp = 9;
                    break;
                case 'A':
                    temp = 10;
                    break;
                case 'B':
                    temp = 11;
                    break;
                case 'C':
                    temp = 12;
                    break;
                case 'D':
                    temp = 13;
                    break;
                case 'E':
                    temp = 14;
                    break;
                default:
                    temp = 15;
                    break;
            }
            System.out.print(HEX_BITS[temp] + " ");
        }
    }
}
