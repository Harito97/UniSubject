package lab1;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        //Define variables
        String inStr;       //input String
        int inStrLength;
        Scanner in = new Scanner(System.in);

        //Prompt and read the input as "String"
        System.out.println("Enter a String: ");
        inStr = in.next();
        inStrLength = inStr.length();
        in.close();

        //Use inStr.charAt(index) in a loop to extract each character
        //The String index begins at 0 from the left
        //Process the String from the right
        for (int charIdx = inStrLength - 1; charIdx >= 0; charIdx--){
            //charIdx = inStrLength - 1, inStrLength - 2, ... , 0
            System.out.print(inStr.charAt(charIdx));
        }
    }
}
