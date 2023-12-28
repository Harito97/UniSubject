package com.oop.collection.polynomials;

import java.util.Objects;

public abstract class AbstractPoly implements Poly{
    double[] derive(){
        if (degree() == 0){
            return new double[0];
        }
        double[] diff = new double[degree()];
        for (int i = 0; i < degree(); i++){
            diff[i] = coefficient(i + 1) * (i + 1);
        }
        return diff;
    }

    @Override
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

    @Override
    public int hashCode(){
        return Objects.hashCode(coefficients());
    }

    @Override
    public String toString(){
        String result = "";
        if (coefficients()[0] < 0) {
            result += " - " + Math.abs(coefficients()[0]);
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
