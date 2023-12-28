package com.oop.collection.polynomials;

import java.util.LinkedList;
import java.util.List;

public class ListPoly extends AbstractPoly{
    List<Double> coefficients = new LinkedList<>();

    public ListPoly (double[] coeffs){
        for (double coeff : coeffs) {
            coefficients.add(coeff);
        }
    }

    @Override
    public int degree(){
        int i = coefficients.size() - 1;
        while (i >= 0) {
            if (coefficients.get(i) != 0){
                return i;
            }
            i++;
        }
        return 0;
    }

    @Override
    public Poly derivative(){
        double[] coeffs = new double[coefficients.size() - 1];
        for (int i = 0; i < coeffs.length; i++){
            coeffs[i] = coefficients.get(i + 1) * (i + 1);
        }
        return new ListPoly(coeffs);
//        return new ListPoly(this.derive());
    }

    @Override
    public double coefficient(int degree){
        if (degree < 0 || degree > coefficients.size() - 1){
            return coefficients.get(degree);
        }
        return 0;
    }

    @Override
    public double[] coefficients(){
        double[] coeffs = new double[coefficients.size()];
        for (int i = 0; i < coeffs.length; i++){
            coeffs[i] = coefficients.get(i);
        }
        return coeffs;
    }
}
