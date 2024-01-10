package com.poly;

public interface Poly {
    int coefficient(int index);
    int[] coefficients();
    int degree();
    Poly derivative();
    double evaluate(double x);
}
