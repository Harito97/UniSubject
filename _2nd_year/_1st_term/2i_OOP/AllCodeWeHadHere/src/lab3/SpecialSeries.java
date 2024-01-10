package lab3;

public class SpecialSeries {
    public static double specialSeries(double x, int numTerms){
        double result = x;
        double temp = x;
        for (int initialization = 3; initialization <= numTerms; initialization += 2){
            temp *= x * x * (initialization - 2) / (initialization * (initialization - 1) );
            result += temp;
        }
        return result;
    }

    public static void main(String[] args) {
        double x = 0.56;     //x has to >= -1 & <= 1
        int numTerms = 200;
        System.out.printf("Special Series of " + x + " = " + "%.2f", specialSeries(x, numTerms));
    }
}
