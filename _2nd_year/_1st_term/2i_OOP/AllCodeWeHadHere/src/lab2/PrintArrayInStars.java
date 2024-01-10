package lab2;

//Exercises on Array

import java.util.Scanner;

public class PrintArrayInStars {
    public static void main(String[] args) {
        //Declare variables
        Scanner in = new Scanner(System.in);

        //Take input
        System.out.print("Enter the number of item : ");
        int numItems = in.nextInt();
        while (numItems <= 0) {             //This make sure the number of items have to >0
            System.out.print("Enter again the number of items (have to >0) : ");
            numItems = in.nextInt();
        }
        int[] items = new int[numItems];   //Allocate the array

        //Read the items into the array and check all items >=0 or not.
        System.out.print("Enter the value of all items (separated by space): ");
        boolean test = true;
        //Flag to check value of item is >=0 or not.
        for (int index = 0; index < items.length; index++){
            items[index] = in.nextInt();
            if (items[index] < 0){
                test = false;
            }
        }
        while (!test){
            //If test = false then it means the user have to input again until it true
            System.out.print("Enter again the value of all items " +
                    "(separated by space and it have to greater than or equal 0): ");
            test = true;
            //Flag to check value of item is >=0 or not.
            for (int index = 0; index < items.length; index++){
                items[index] = in.nextInt();
                if (items[index] < 0){
                    test = false;
                }
            }
        }
        in.close();

        //Print result
        for (int idx = 0; idx < items.length; idx++){
            System.out.print(idx + ": ");
            for (int starNo = 1; starNo <= items[idx]; starNo++){
                System.out.print("*");
            }
            System.out.println("(" + items[idx] + ")");
        }
    }
}
