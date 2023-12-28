package com.poly;

public abstract class AbstractPoly implements Poly{
    //Attributes
    protected int degree;

    //Constructor
    public AbstractPoly() {
    }

    //APIs
    public int degree(){
        return degree;
    }

    int[] differentiate(){
        if (degree() == 0){
            return new int[0];
        }
        int[] diff = new int[degree()];
        for (int i = 1; i < degree(); i++){
            diff[i - 1] = coefficient(i) * (i);
        }
        return diff;
    }

    public boolean equals(Object o){
        if (o == null){
            return false;
        }
        if (!(o instanceof AbstractPoly abstractPoly)){
            return false;
        }
        for (int i = 0; i <= degree(); i++){
            if (coefficient(i) != abstractPoly.coefficient(i)){
                return false;
            }
        }
        return true;
    }


    public double evaluate(double x){
        double result = 0.0;
        for (int i = 0; i <= degree() - 1; i++){
            result += coefficient(i) * x;
        }
        return result;
    }

    @Override
    public String toString(){
        String result = "";
        if (coefficients() == null){
            return result;
        }
        if (coefficients()[0] < 0) {
            result += "- " + Math.abs(coefficients()[0]);
        } else if (coefficients()[0] == 0) {
            result += "";
        } else {
            result += coefficients()[0];
        }
        for (int i = 1; i < coefficients().length; i++) {
            if (coefficients()[i] == 1) {
                result += " + " + "x^" + i;
            } else if (coefficients()[i] < 0 && coefficients()[i] != -1) {
                result += " - " + Math.abs(coefficients()[i]) + " * x^" + i;
            } else if (coefficients()[i] == -1) {
                result += " - " + "x^" + i;
            } else if (coefficients()[i] == 0) {
                result += "";
            } else {
                result += " + " + coefficients()[i] + " * x^" + i;
            }
        }
        return result;
    }
}
