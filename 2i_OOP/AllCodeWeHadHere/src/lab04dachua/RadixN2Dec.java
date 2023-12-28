import java.util.Scanner;

public class RadixN2Dec {
    public static boolean isRightFormat(String inStr, int radix) {
        inStr = inStr.toUpperCase();
        if (radix >= 2 && radix <= 10) {
            for (int charIdx = 0; charIdx < inStr.length(); charIdx++) {
                char inChar = inStr.charAt(charIdx);
                if (!(inChar >= '0' && inChar < '0' + radix)) {
                    return false;
                }
            }
            return true;
        } else if (radix > 10 && radix <= 36) {
            for (int charIdx = 0; charIdx < inStr.length(); charIdx++) {
                char inChar = inStr.charAt(charIdx);
                if (!((inChar >= '0' && inChar < '9') || (inChar >= 'A' && inChar < 'A' + radix - 10))) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static int convert(String inStr, int radix) {
        inStr = inStr.toUpperCase();
        char firstChar = inStr.charAt(0);
        int inDecimal = ((firstChar >= '0') && (firstChar <= '9')) ? (firstChar - '0') : firstChar - 'A' + 10;

        for (int charIdx = 1; charIdx < inStr.length(); charIdx++) {
            char inChar = inStr.charAt(charIdx);
            if (inChar >= '0' && inChar <= '9') {
                inDecimal = inDecimal * radix + (inChar - '0');
            } else {
                inDecimal = inDecimal * radix + (inChar - 'A' + 10);
            }
        }
        return inDecimal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radix: ");
        int radix = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the string: ");
        String inStr = sc.nextLine();
        sc.close();

        if (isRightFormat(inStr, radix)) {
            System.out.println("The equivalent decimal number \"" + inStr + "\" is: " + convert(inStr, radix));
        } else {
            System.out.println("error: Invalid String or Radix out of bounds");
        }

    }
}
