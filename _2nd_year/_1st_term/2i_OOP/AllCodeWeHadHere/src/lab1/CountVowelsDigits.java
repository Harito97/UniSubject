package lab1;

import java.util.Scanner;

public class CountVowelsDigits {
    public static void main(String[] args) {
        //Declare variables
        String inputStr;
        int numVowels = 0;
        int numDigits = 0;
        int strLength;
        char charAtIndex;
        Scanner in = new Scanner(System.in);

        //Get input
        System.out.println("Enter a String: ");
        inputStr = in.next().toLowerCase();         //toLowerCase to reduce the case in "if-else"
	in.close();
	
        //Process input
        strLength = inputStr.length();
        for (int strIndex = 0; strIndex < strLength; strIndex++){
            charAtIndex = inputStr.charAt(strIndex);
            if (charAtIndex >= '0' && charAtIndex <= '9'){
                numDigits += 1;
            } else if (charAtIndex == 'a' || charAtIndex == 'e' || charAtIndex == 'i' ||
                        charAtIndex == 'o' || charAtIndex == 'u'){
                numVowels += 1;
            }
        }

        //Print the result
        System.out.print("Number of vowels: ");
        System.out.printf("%5d", numVowels);
        System.out.print("  (" + Math.round( (double) numVowels / strLength * 10000 ) / 100.0 + "%)");
        System.out.println();
        System.out.print("Number of digits: ");
        System.out.printf("%5d", numDigits);
        System.out.print("  (" + Math.round( (double) numDigits / strLength * 10000 )  / 100.0 + "%)");
    }
}
