package lab1;

import java.util.Scanner;

public class SquarePattern {
    public static void main (String args[]){
        //Declare variables
        int size;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size: ");
        size = in.nextInt();
        in.close();

        //Outer loop to print each of the rows
        for (int row = 1; row <= size; row++){      //row = 1,2,3,..., size
            for (int col = 1; col <= size; col++){  //column = 1,2,3,...,size
                System.out.print("#");              //print without new line
            }
            System.out.println();                   //make a new line when a row be completed
        }
    }
}
