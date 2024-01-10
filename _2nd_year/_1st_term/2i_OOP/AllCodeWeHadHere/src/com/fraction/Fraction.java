package com.fraction;

public class Fraction extends Number implements Comparable{
    //Attributes
    private int numerator;
    private int denominator;

    //Constructor
    public Fraction(Fraction newFrac) {
        this.denominator = newFrac.getDenominator();
        this.numerator = newFrac.getNumerator();
    }

    public Fraction(int newNumerator){
        this.numerator = newNumerator;
        this.denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    //Setters, Getters
    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    //Implementation
    private static int gcd(int firstNum, int secondNum){
        while (firstNum % secondNum != 0){
            int residual = firstNum / secondNum;
            firstNum = secondNum;
            secondNum = residual;
        }
        return secondNum;
    }

    private void simplify(){
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    //Interface (APIs)
    public Fraction add(Fraction newFrac){
        this.simplify();
        newFrac.simplify();

        Fraction result = new Fraction(0);
        result.setNumerator(this.numerator * newFrac.getDenominator() + newFrac.getNumerator() * this.denominator);
        result.setDenominator(this.denominator * newFrac.getDenominator());
        return result;
    }

    public Fraction add(int newFrac){
        this.simplify();

        Fraction result = new Fraction(0);
        result.setNumerator(this.numerator + newFrac * this.denominator);
        //result.setDenominator(this.denominator * 1);  denominator not change
        return result;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Fraction){
            if (o == null){
                return Integer.parseInt(null);
            }
            Fraction anotherFrac = (Fraction) o;
            this.simplify();
            anotherFrac.simplify();
            if (this.numerator == anotherFrac.getNumerator()
                    && this.denominator == anotherFrac.getDenominator()){
                return 0;
            }
            anotherFrac.setNumerator(-1 * anotherFrac.getNumerator());
            Fraction flagTest = new Fraction(0);
            flagTest = this.add(anotherFrac);
            return flagTest.getNumerator() - flagTest.getDenominator();
        }
        return Integer.parseInt(null);
    }

//    public int compareTo(Fraction anotherFrac){
//        this.simplify();
//        anotherFrac.simplify();
//        if (this.numerator == anotherFrac.getNumerator() && this.denominator == anotherFrac.getDenominator()){
//            return 0;
//        }
//        anotherFrac.setNumerator(-1 * anotherFrac.getNumerator());
//        Fraction flagTest = new Fraction(0);
//        flagTest = this.add(anotherFrac);
//        return flagTest.getNumerator() - flagTest.getDenominator();
//    }

    public double doubleValue(){
        this.simplify();
        return 1.0 * this.numerator / this.denominator;
    }

    public float floatValue(){
        return 1.0f * this.numerator / this.denominator;
    }

    public int intValue(){
        return (int) this.numerator / this.denominator;
    }

    public long longValue(){
        return (long) this.numerator / this.denominator;
    }

    public String toString(){
        return "\"Fraction[" + this.numerator
                + "/" + this.denominator + "]\"";
    }

    public boolean equals(Fraction anotherFrac){
        return this.compareTo(anotherFrac) == 0;
    }

    public static void main(String[] args) {

    }

}
