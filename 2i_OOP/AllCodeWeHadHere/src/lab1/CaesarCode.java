package lab1;

import java.util.Scanner;

public class CaesarCode {
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
            if ( temp >= 'X' && temp <= 'Z'){
                switch (temp){
                    case 'X': System.out.print('A');
                    case 'Y': System.out.print('B');
                    case 'Z': System.out.print('C');

                }
            } else {
                System.out.print( (char) (temp + 3) );
            }
        }
    }
}
