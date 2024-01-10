package com.poly;

import java.util.ArrayList;
import java.util.List;

public class ListPoly extends AbstractPoly {
    //Attributes
    private List<Integer> coefficients = new ArrayList<>();

    //Constructor
    public ListPoly(int[] coefficients_intArray) {
        if (coefficients_intArray == null) return;
        List<Integer> coefficients_list = new ArrayList<>();
        for (int x : coefficients_intArray){
            coefficients_list.add(x);
        }
        super.degree = coefficients_list.size() - 1;
        this.coefficients = coefficients_list;
    }

    //APIs
    public int coefficient(int index){
        return coefficients.get(index);
    }

    public int[] coefficients(){
        if (coefficients == null) return null;
        int[] result = new int[coefficients.size()];
        for (int i = 0; i < result.length; i++){
            result[i] = coefficient(i);
        }
        return result;
    }

    public Poly derivative(){
        int[] coeffs = new int[coefficients.size() - 1];
        for (int i = 0; i < coeffs.length; i++){
            coeffs[i] = coefficients.get(i + 1) * (i + 1);
        }
        return new ListPoly(coeffs);
        //return  (Poly) new ListPoly(this.differentiate());
    }

    public ListPoly minus(ListPoly anotherPoly){
        this.reduce();
        anotherPoly.reduce();
        int size = Math.max(this.degree, anotherPoly.degree());
        int[] soTru = this.differentiate();
        int[] soBiTru = anotherPoly.coefficients();
        int[] result = new int[size];
        for (int i = 0; i < size; i++){
            result[i] = soTru[i] - soBiTru[i];
        }
        return new ListPoly(result);
    }

    public ListPoly plus(ListPoly anotherPoly){
        this.reduce();
        anotherPoly.reduce();
        int size = Math.max(this.degree, anotherPoly.degree());
        int[] soCong = this.differentiate();
        int[] soDuocCong = anotherPoly.coefficients();
        int[] result = new int[size];
        for (int i = 0; i < size; i++){
            result[i] = soCong[i] + soDuocCong[i];
        }
        return new ListPoly(result);
    }

    public ListPoly time(ListPoly anotherPoly){
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
        return new ListPoly(result);
    }

    public String type(){
        return "ListPoly";
    }

    //Implementation
    private void reduce(){
        for (int i = coefficients.size() - 1; i >= 0; i++){
            if (coefficient(i) == 0){
                degree--;
            }
        }
    }
}
