public class PrimeFactor {
    public static boolean isProductOfPrimeFactors(int aPosInt) {
        int product = 1;
        for (int i = 2; i <= aPosInt / 2; i++) {
            if (aPosInt % i == 0 && PrimeList.isPrime(i)) {
                product *= i;
                if (product > aPosInt) {
                    return false;
                }
            }
        }
        return product == aPosInt;
    }

    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++) {
            if (isProductOfPrimeFactors(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
