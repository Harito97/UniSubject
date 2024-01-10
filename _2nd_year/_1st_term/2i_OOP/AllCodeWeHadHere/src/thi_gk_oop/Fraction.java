package thi_gk_oop;

public class Fraction extends Number {
    //Thuoc tinh
    private int numerator;
    private int denominator;

    //Ham dung
    public Fraction(Fraction input){
        this.numerator = input.numerator;
        this.denominator = input.denominator;
    }
    public Fraction(int input){
        this.numerator = input;
        this.denominator = 1;
    }
    public Fraction(int input1, int input2){
        this.numerator = input1;
        this.denominator = input2;
    }

    //Phuong thuc
    public Fraction add(Fraction input){
        Fraction fraction1 = new Fraction(this.numerator, this.denominator);
        Fraction fraction2 = new Fraction(input);
        Fraction result = new Fraction(fraction1.numerator * fraction2.denominator
                + fraction2.numerator * fraction1.denominator,
                fraction1.denominator * fraction2.denominator);
        return result;
    }
    public Fraction add(int input){
        Fraction fraction1 = new Fraction(this.numerator, this.denominator);
        Fraction fraction2 = new Fraction(input);
        Fraction result = new Fraction(fraction1.numerator * fraction2.denominator
                + fraction2.numerator * fraction1.denominator,
                fraction1.denominator * fraction2.denominator);
        return result;
    }
    public int compareTo(Fraction input){
        Fraction fr1 = new Fraction(this.numerator, this.denominator);
        Fraction fr2 = new Fraction(input);
        fr1.simplify();
        fr2.simplify();
        int test1 = fr1.numerator * fr2.denominator;
        int test2 = fr2.numerator * fr1.denominator ;
        
        return -1;
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    public double doubleValue(){
        return 1.0;
    }
    public boolean equals(Fraction input){
        return false;
    }
    private int gcd(int input1, int input2){
        //Tim UCLN
        final int UPPERBOUND = Math.min(input1, input2);
        int uoc_chung_cua_input1 = 1;
        int uoc_chung_cua_input2 = 1;
        for (int idx = 1; idx <= UPPERBOUND; idx++){
            if (input1 % idx == 0){
                uoc_chung_cua_input1 = idx;
            }
            if (input2 % idx == 0){
                uoc_chung_cua_input2 = idx;
            }
        }
        return Math.min(uoc_chung_cua_input1, uoc_chung_cua_input2);
    }
    private void simplify(){
        //Toi gian phan so
        int gcd = gcd(this.numerator, this.denominator);
        this.numerator = this.numerator / gcd;
        this.denominator = this.denominator / gcd;
    }

}
