import java.util.Scanner;
public class Dec2Hex {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter a decimal number: ");
        int decimal = Integer.parseInt(input.next());

        System.out.println("The equivalent hexadecimal number is " + ConvertToHex(decimal));
    }

    public static String ConvertToHex(int decimal) {
        int surplus;
        String str = "";
        char hexChars[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (decimal > 0) {
            surplus = decimal % 16;
            str =str+ hexChars[surplus];
            decimal = decimal / 16;
        }
        return str;
    }
}
