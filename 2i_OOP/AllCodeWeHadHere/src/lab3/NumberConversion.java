package lab3;

import java.util.Scanner;

public class NumberConversion {
    //The input and output are treated as String
    public static String toRadix (String input, int inRadix, int outRadix){
        int inDecimal = convertInputRadixToDecimal(input, inRadix);
        String output = convertDecimalToOutputRadix(inDecimal, outRadix);
        return output;
    }

    //Check the input String is a inRadix number or not
    //- in these case we only use inRadix from 1 to 36
    public static boolean isRightFormat(String input, int inRadix) {
        input = input.toUpperCase();
        if (inRadix >= 2 && inRadix <= 10) {
            for (int charIdx = 0; charIdx < input.length(); charIdx++) {
                char inChar = input.charAt(charIdx);
                if (!(inChar >= '0' && inChar < '0' + inRadix)) {
                    return false;
                }
            }
            return true;
        } else if (inRadix > 10 && inRadix <= 36) {
            for (int charIdx = 0; charIdx < input.length(); charIdx++) {
                char inChar = input.charAt(charIdx);
                if (!((inChar >= '0' && inChar < '9') ||
                        (inChar >= 'A' && inChar < 'A' + inRadix - 10))) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    //Convert the input number with radix = inRadix to radix = 10
    public static int convertInputRadixToDecimal(String input, int inRadix) {
        input = input.toUpperCase();
        char firstChar = input.charAt(0);
        int inDecimal = ((firstChar >= '0') && (firstChar <= '9')) ? (firstChar - '0') : firstChar - 'A' + 10;

        for (int charIdx = 1; charIdx < input.length(); charIdx++) {
            char inChar = input.charAt(charIdx);
            if (inChar >= '0' && inChar <= '9') {
                inDecimal = inDecimal * inRadix + (inChar - '0');
            } else {
                inDecimal = inDecimal * inRadix + (inChar - 'A' + 10);
            }
        }
        return inDecimal;
    }

    //Convert the input number with radix = 10 to radix = outRadix
    public static String convertDecimalToOutputRadix(int inDecimal, int outRadix) {
        String output = "";
        if(inDecimal >= outRadix){
            output += convertDecimalToOutputRadix(inDecimal / outRadix, outRadix);
            //use đệ quy để lấy ngược kết quả sau khi thực hiện lấy phần dư ngược lên
        }
        if(inDecimal % outRadix > 9){
            output += inDecimal % outRadix + 55;
            //if phần dư lớn hơn 9 thì +55
            //để đưa phần dư đó đến phần mã của các chữ cái
            //vỉ mã ASCII của A là 65
        } else {
            output += inDecimal % outRadix;
            //if phần dư đó nhỏ hơn 9 thì giữ nguyên mã đó để cộng vào
        }
        return output;
    }

    //Test Driver
    public static void main(String[] args) {
        String input = "ABCD";
        int inRadix = 16;
        int outRadix = 2;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number and radix: ");
        input = sc.next();
        System.out.print("Enter the input radix: ");
        inRadix = Integer.parseInt(sc.next());
        System.out.print("Enter the out radix: ");
        outRadix = Integer.parseInt(sc.next());

        String output = toRadix(input, inRadix, outRadix);
        System.out.print("\"" + input + "\" in radix " + inRadix +
                " is \"" + output + "\" in radix " + outRadix);
    }
}
