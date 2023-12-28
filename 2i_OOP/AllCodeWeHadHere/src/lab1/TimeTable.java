package lab1;

import java.util.Scanner;

public class TimeTable {
    public static void main (String args[]){
        //Declare variables
        int size;
        Scanner in = new Scanner(System.in);

        //Print the message for user to input the size of the multiplication table
        System.out.println("Enter the size of the multiplication table: ");
        size = in.nextInt();
        in.close();

        //Process the input and display the multiplication table with size x size
        //Print the first line
        System.out.printf("%4s", "* |");
        for (int col = 1; col <= size; col++){
            System.out.printf("%4s", String.valueOf(col));
        }
        //Print the second line
        System.out.println();                                       //Go to the second line
        for (int col = 1; col <= size + 1; col++){
            System.out.printf("%4s", "----");
        }
        //Print the multiplication table (with the size: size x size) from the third line
        System.out.println();                                       //Go to the third line
        for (int row = 1; row <= size ; row++){
            System.out.printf("%4s", String.valueOf(row) + "|");    //Print the String be started in each line
            for (int col = 1; col <= size; col++){
                System.out.printf("%4d", col * row);                //Print out the value after performing the multiplication
            }
            System.out.println();                                   //Go to the next line after the previous line be completed
        }
    }
}
