package lab2;

import java.util.Scanner;

public class MagicSum {
    //The method helps know is the digit 8 in the number or not
    public static boolean hasEight (int number){
        int flag;
        while (number / 10 != 0){
            flag = number % 10;
            if (flag == 8){
                return true;
            }
        }
        return false;
    }

    //Main method
    public static void main(String[] args) {
        final int SENTINEL = -1;        //Terminating input
        int number;
        int sum = 0;
        Scanner in = new Scanner(System.in);

        //Read first input to "seed" the while loop
        System.out.print("Enter a positive integer (or -1 to end): ");
        number = in.nextInt();

        while (number != SENTINEL){
            //Repeat until input is -1
            if (hasEight(number)){
                sum += number;
            }
            //Read next input. Repeat if the input is not the SENTINEL
            //Take note that you need to repeat these codes!
            System.out.print("Enter again a positive integer (or -1 to end): ");
            number = in.nextInt();
        }

        System.out.print("The magic sum is: " + sum);
    }
}
