package lab1;

import java.util.Scanner;

public class TestPalindromicWord {
    public static void main(String[] args) {
        //Declare variables
        String input;
        int inputLength;
        Scanner in = new Scanner(System.in);
        boolean test = true;

        //Get input
        System.out.print("Enter a word: ");
        input = in.next().toUpperCase();
        inputLength = input.length();

        //Process input
        for (int index = 0; index <= inputLength / 2; index++){
            if (input.charAt(index) != input.charAt(inputLength - 1 - index)){
                test = false;
            }
        }

        //Print result
        if (test){
            System.out.print("This is a palindromic word.");
        } else {
            System.out.print("This is not a palindromic word.");
        }
    }
}
