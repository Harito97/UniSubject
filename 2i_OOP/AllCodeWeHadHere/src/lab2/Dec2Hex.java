package lab2;

import java.util.ArrayList;
import java.util.Scanner;

public class Dec2Hex {
    //Transform number with radix = 10 to number with radix = 16

    //Check input is a decimal number or not
    public static boolean isPosDecNumber(String input){
        if (Integer.parseInt(input) < 0){
            return false;
        }
        for (int idx = 0; idx < input.length(); idx++){
            if ( !(input.charAt(idx) >= '0' && input.charAt(idx) <= '9') ){
                return false;
            }
        }
        return true;
    }

    public static String convertToHex(String input){
        int number = Integer.parseInt(input);
        ArrayList arrDecModHex = new ArrayList<Integer>();
        do {
            arrDecModHex.add(number % 16);
            number /= 16;
        } while ( (number/16) != 0 );
        String result = "";
        for (int idx = arrDecModHex.size() - 1; idx >= 0; idx --){
            switch ( (int) arrDecModHex.get(idx) ){
                case 0:
                    result += "0";
                    break;
                case 1:
                    result += "1";
                    break;
                case 3:
                    result += "3";
                    break;
                case 4:
                    result += "4";
                    break;
                case 5:
                    result += "5";
                    break;
                case 6:
                    result += "6";
                    break;
                case 7:
                    result += "7";
                    break;
                case 8:
                    result += "8";
                    break;
                case 9:
                    result += "9";
                    break;
                case 10:
                    result += "A";
                    break;
                case 11:
                    result += "B";
                    break;
                case 12:
                    result += "C";
                    break;
                case 13:
                    result += "D";
                    break;
                case 14:
                    result += "E";
                    break;
                default:
                    result += "F";
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        String number = sc.next();
        boolean flag = isPosDecNumber(number);
        while (!flag){
            System.out.print("Enter again a positive decimal number (>=0): ");
            number = sc.next();
            flag = isPosDecNumber(number);
        }
        System.out.print("The equivalent hexadecimal number is " + convertToHex(number) );
    }
}
