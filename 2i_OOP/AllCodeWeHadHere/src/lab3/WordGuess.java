package lab3;

import java.util.Scanner;

public class WordGuess {
    public static void main(String[] args) {
        //get the input
//        String input = args[0];
        Scanner sc = new Scanner(System.in);
        System.out.print("Key in one character or your guess word: ");
        String input = "get_what_haha";
        String user_guess = sc.nextLine();
        int lengthInput = input.length();
        int countTrials = 1;
        char[] temp = new char[lengthInput];

        for (int idx = 0; idx < lengthInput; idx++){
            temp[idx] = '_';
        }

        while (user_guess.compareTo(input) != 0){
            System.out.print("Trial " + countTrials + ": ");
            for (int idx = 0; idx < lengthInput; idx++){
                if (input.charAt(idx) == user_guess.charAt(0)){
                    temp[idx] = user_guess.charAt(0);
                }
            }
            System.out.print(temp);
            countTrials++;
            System.out.printf("%nKey in one character or your guess word: ");
            user_guess = sc.next();
        }
        System.out.printf("Congratulation!%nYou got it in " + countTrials + " trials!");
    }
}
