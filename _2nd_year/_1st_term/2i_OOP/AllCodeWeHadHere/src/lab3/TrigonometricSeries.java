package lab3;

public class TrigonometricSeries {
    public static double sin(double x, int numTerms){
        double result = x;
        double temp = x;
        for (int initialization = 3; initialization <= numTerms; initialization+=2){
            temp *= -x*x / (initialization * (initialization - 1));
            result += temp;
        }
        return result;
    }

    public static double cos(double x, int numTerms){
        double result = 1.0;
        double temp = 1.0;
        for (int initialization = 2; initialization <= numTerms; initialization+=2){
            temp *= -x*x / (initialization * (initialization - 1));
            result += temp;
        }
        return result;
    }

    public static void main(String[] args) {
        double x = Math.PI / 4;
        int numTerms = 200;
        System.out.printf("sin(" + x + ") = " + "%.2f", sin(x, numTerms));
        System.out.printf("%nCompare to method Math.sin = " + "%.2f", Math.sin(x));

        System.out.printf("%ncos(" + x + ") = " + "%.2f", cos(x, numTerms));
        System.out.printf("%nCompare to method Math.cos = " + "%.2f", Math.cos(x));
    }
}
