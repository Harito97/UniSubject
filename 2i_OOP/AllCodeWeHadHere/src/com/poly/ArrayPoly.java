package com.poly;

public class ArrayPoly extends AbstractPoly{
    //Attributes
    int[] coefficients = new int[0];

    //Constructor
    public ArrayPoly(int[] coefficients){
        super.degree = coefficients.length - 1;
        this.coefficients = coefficients;
    }

    //APIs
    @Override
    public int coefficient(int index){
        return coefficients[index];
    }

    @Override
    public int[] coefficients(){
        return coefficients;
    }

    public Poly derivative(){
        int[] DerivativeCoefficients = new int[coefficients.length - 1];
        for (int i = 0; i < DerivativeCoefficients.length; i++){
            DerivativeCoefficients[i] = coefficients[i + 1] * (i + 1);
        }
        return new ArrayPoly(DerivativeCoefficients);
        //return  (Poly) new ArrayPoly(this.differentiate());
    }

    public ArrayPoly minus(ArrayPoly anotherPoly){
        this.reduce();
        anotherPoly.reduce();
        int size = Math.max(this.degree, anotherPoly.degree());
        int[] soTru = this.differentiate();
        int[] soBiTru = anotherPoly.coefficients();
        int[] result = new int[size];
        for (int i = 0; i < size; i++){
            result[i] = soTru[i] - soBiTru[i];
        }
        return new ArrayPoly(result);
    }

    public ArrayPoly plus(ArrayPoly anotherPoly){
        this.reduce();
        anotherPoly.reduce();
        int size = Math.max(this.degree, anotherPoly.degree());
        int[] soCong = this.differentiate();
        int[] soDuocCong = anotherPoly.coefficients();
        int[] result = new int[size];
        for (int i = 0; i < size; i++){
            result[i] = soCong[i] + soDuocCong[i];
        }
        return new ArrayPoly(result);
    }

    public ArrayPoly time(ArrayPoly anotherPoly){
        this.reduce();
        anotherPoly.reduce();
        int size = this.degree() + anotherPoly.degree();
        int[] soNhan = this.differentiate();
        int[] soDuocNhan = anotherPoly.coefficients();
        int[] result = new int[size];
        for (int i = 0; i < soNhan.length; i++){
            for (int j = 0; j < soDuocNhan.length; j++){
                result[i + j] = soNhan[i] * soDuocNhan[j];
            }
        }
        return new ArrayPoly(result);
    }

    public String type(){
        return "ArrayPoly";
    }

    //Implementation
    private void reduce(){
        for (int i = coefficients.length - 1; i >= 0; i++){
            if (coefficient(i) == 0){
                degree--;
            }
        }
    }
}
