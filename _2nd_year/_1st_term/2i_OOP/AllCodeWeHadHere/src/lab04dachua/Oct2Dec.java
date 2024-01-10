import java.util.Scanner;

public class Oct2Dec {
    public static boolean isOctStr(String inStr) {
        inStr = inStr.toUpperCase();
        for (int charIdx = 0; charIdx < inStr.length(); charIdx++) {
            char inChar = inStr.charAt(charIdx);
            if (!(inChar >= '0' && inChar < '0' + 8)) {
                return false;
            }
        }
        return true;
    }

    public static int convertOct2Dec(String inStr) {
        inStr = inStr.toUpperCase();
        int inDecimal = inStr.charAt(0) - '0';

        for (int charIdx = 1; charIdx < inStr.length(); charIdx++) {
            char inChar = inStr.charAt(charIdx);
            inDecimal = inDecimal * 8 + (inChar - '0');
        }
        return inDecimal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Octal string: ");
        String octStr = sc.nextLine();
        sc.close();

        if (isOctStr(octStr)) {
            System.out.println("The equivalent decimal number for octal \"" + octStr + "\" is: " + convertOct2Dec(octStr));
        } else {
            System.out.println("error: invalid octal string \"" + octStr + "\"");
        }
    }
}
