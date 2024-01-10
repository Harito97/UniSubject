package lab4;

import java.util.Scanner;

public class PerfectPrimeFactorList {
    //Test the number input co the phan tich thanh tich cua cac so nguyen to hay khong
    //(suy ra no khong duoc la 1 so nguyen to va duoc tao thanh tu cac tich cua cac so nguyen to)
    //Luu y: phan ket qua trong de bai so sanh voi dau ra vi du cua de co su khac nhau
    //-> Vi du dau ra cua de la sai so voi mo ta cua de bai
    //Eg: 4 ra false vi 4 = 2 * 2 but there are 2 same prime number
    //Tuy nhien theo mo ta cua de bai thi 4 phai ra gia tri true moi dung vi 4 co the phan tich thanh tich cua cac so nguyen to
    public static boolean isProductOfPrimeFactors(int aPosInt){
        if (aPosInt <= 1){  //vi cac so <= 1 khong the phan tich thanh tich cua cac thua so nguyen to
            return false;
        }
        int result = aPosInt;
        for (int i = 2; i <= aPosInt / 2; i++){
            if (PrimeList.isPrime(i)){
                while (result % i == 0){
                    result /= i;    //Eg: 4 will return true because 4 = 2 * 2 is product of 2 and 2 (2 is a prime)
                }
            }
        }
        return result == 1;
    }

    //Main
    public static void main(String[] args) {
        System.out.print("Enter the upper bound: ");
        Scanner sc = new Scanner(System.in);
        int upperBound = sc.nextInt();
        System.out.println("These numbers are equal to the product of prime factors: ");
        int count = 0;
        for (int i = 1; i < upperBound; i++){
            if (isProductOfPrimeFactors(i)){
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.printf("%n%s%d%s%.2f%s", "[", count, " numbers found (",
                count * 100.0 / upperBound, "%)]");
    }
}
