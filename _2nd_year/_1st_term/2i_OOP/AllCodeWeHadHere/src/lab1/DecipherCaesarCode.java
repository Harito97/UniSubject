package lab1;

import java.util.Scanner;

public class DecipherCaesarCode {
    public static void main(String[] args) {
        //Declare variables
        String input;
        int inputLength;
        Scanner in = new Scanner(System.in);

        //Get input
        System.out.print("Enter a plaintext string: ");
        input = in.next().toUpperCase();
        inputLength = input.length();

        //Process input
        System.out.print("The ciphertext string is: ");
        for (int index = 0; index < inputLength; index++){
            char temp = input.charAt(index);
            if ( temp >= 'A' && temp <= 'C'){
                switch (temp){
                    case 'A': System.out.print('X');
                    case 'B': System.out.print('Y');
                    case 'C': System.out.print('Z');
                    default:
                }
            } else {
                System.out.print( (char) (temp - 3) );
            }
        }
    }
}
