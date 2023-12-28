package lab3;

import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        //create a secret number from 0 to 100
        final int SECRET_NUMBER = (int) (Math.random() * 100);
        Scanner sc = new Scanner(System.in);
        System.out.println("Key in your guess: ");
        int user_guess = sc.nextInt();
        int countTrials = 1;
        while (user_guess != SECRET_NUMBER){
            if (user_guess > SECRET_NUMBER){
                System.out.println("Try lower");
                user_guess = sc.nextInt();
            } else {
                System.out.println("Try higher");
                user_guess = sc.nextInt();
            }
            countTrials++;
        }
        System.out.println("You got it in " + countTrials + " trials!");
    }
}
