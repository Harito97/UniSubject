package lab1;

import java.util.Scanner;

public class CheckerPattern {
    public static void main(String[] args) {
        //Declare variables
        int size;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size: ");
        size = in.nextInt();
        in.close();

        //Outer loop to print each of the rows
        for (int row = 1; row <= size; row++) {      //row = 1, 2,..., size
            //Inner loop to print each of the columns of a particular row
            for (int col = 1; col <= size; col++) {  //col = 1, 2,..., size
                if ((row % 2) == 0) {               //row = 2, 4,..., size then we back a space
                    System.out.print(" ");
                }
                System.out.print("# ");             //1 part of the content will be display in a line / row
            }
            //Make a new line when the previous line be completed
            System.out.println();
        }
    }
}
