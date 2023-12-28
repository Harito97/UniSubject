package lab1;

import java.util.Scanner;

public class HillPatternB {
    public static void main(String[] args) {
        //Declare variables
        int numRows;
        boolean test = false;
        Scanner in = new Scanner(System.in);

        //Send a message for user to make sure they know the input
        do {
            System.out.println("Enter the row (>=1) of the hill pattern B: ");
            numRows = in.nextInt();
            if (numRows >= 1){
                test = true;
            }
        } while (!test);

        for (int row = 1; row <= numRows; row++){
            //numCol = 2 x numRows - 1
            for (int col = 1; col <= 2 * numRows - 1; col++){
                if ((row + col >= 2 * row) && (row + col <= 2 * numRows)){
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
