package lab2;

//Exercises on Array

import java.util.Scanner;

public class PrintArray {
    public static void main(String[] args) {
        //Declare variables
        Scanner in = new Scanner(System.in);

        //Take input
        System.out.print("Enter the number of items : ");
        int temp = in.nextInt();
        while (temp < 0){
            System.out.print("Enter the number of items (a non-negative integer) : ");
            temp = in.nextInt();
        }
        final int NUM_ITEMS = temp;
        int[] items = new int[NUM_ITEMS];   //Allocate the array

        //Read the items into the array and print on screen
        if (items.length == 0){     //The size of array =0
            System.out.print("The array has no items.");
        } else {                    //The size of array >0
            System.out.print("Enter the value of all items (separated by space) : ");
            for (int index = 0; index < items.length; index++){
                items[index] = in.nextInt();
            }

            //Print the array in case the size of array >0
            System.out.print("The values are : [");
            for (int index = 0; index < items.length; index++){
                if (index == 0){
                    System.out.print(items[index]);
                } else {
                    System.out.print(", " + items[index]);
                }
            }
            System.out.print("]");
        }
        in.close();
    }
}