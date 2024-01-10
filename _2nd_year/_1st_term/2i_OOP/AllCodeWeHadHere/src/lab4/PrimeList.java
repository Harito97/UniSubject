package lab4;

import java.util.Scanner;

public class PrimeList {
    //Method help check a positive number is prime or not
    public static boolean isPrime(int aPosInt){
        if (aPosInt <= 0){
            return false;
        }
        double sqrtNumber = Math.sqrt(aPosInt);
        for (int i = 2; i <= sqrtNumber; i++){
            if (aPosInt % i == 0){
                return false;
            }
        }
        return true;
    }

    //Case test
    public static void main(String[] args) {
        System.out.print("Please enter the upper bound: ");
        Scanner sc = new Scanner(System.in);
        int upperBound = sc.nextInt();
        if (upperBound <= 0){
            System.out.printf("%nWrong input!%nInput is a positive number.");
            return;
        }
        int countPrime = 0;
        for (int value = 2; value <= upperBound; value++){
            //value run from 2 because 1 is not a prime
            //-> we don't need to run from 1 to save 1 time
            if (isPrime(value)){
                System.out.println(value);
                countPrime++;
            }
        }
        System.out.printf("%s%.2f%s", "[" + countPrime + " primes found (",
                countPrime * 100.0 / upperBound, "%)]");
    }
}
