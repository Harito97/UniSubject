package lab1;

import java.util.Scanner;

public class ExchangeCipher {
    public static void main(String[] args) {
        //Declare variables
        String input;
        int inputLength;
        Scanner in = new Scanner(System.in);
        char cipherTextChar, plainTextChar;

        //Get input
        System.out.print("Enter a plaintext string: ");
        input = in.next().toUpperCase();
        inputLength = input.length();

        //Process input
        System.out.print("The ciphertext string is: ");
        for (int index = 0; index < inputLength; index++){
            plainTextChar = input.charAt(index);
            cipherTextChar = (char) ('A' + 'Z' - plainTextChar);
            System.out.print( cipherTextChar );
        }
    }
}
