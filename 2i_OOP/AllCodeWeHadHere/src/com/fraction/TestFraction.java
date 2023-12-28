package com.fraction;

import java.util.ArrayList;
import java.util.List;

public class TestFraction {
    //Attributes
    private List<Fraction> fractions = new ArrayList<>();

    //Constructor
    public TestFraction() {
        int[][] initialization = new int[30][2];
        for (int i = 0; i < 30; i++){
            for (int j = 0; j < 2; j++){
                initialization[i][j] = (int) (Math.random() * 1000);
                if (initialization[i][j] == 0){
                    initialization[i][j] += 1;
                }
            }
        }

        for (int i = 0; i < 30; i++){
            Fraction frac = new Fraction(initialization[i][0],
                    initialization[i][1]);
            fractions.add(frac);
        }
    }

    //APIs
    public Fraction getSecondLargestValue(){
        Fraction secondLargestValue = new Fraction(0);
        Fraction theLargestValue = new Fraction(0);
        for (Fraction x : fractions){
            if (theLargestValue.floatValue() < x.floatValue()){
                theLargestValue = x;
            }
        }
        for (Fraction x : fractions){
            if (secondLargestValue.floatValue() < x.floatValue()
                && x.floatValue() != theLargestValue.floatValue()){
                secondLargestValue = x;
            }
        }
        return secondLargestValue;
    }

    public void print(List<Fraction> fractions){
        for (Fraction x : fractions){
            System.out.println(x.toString());
        }
    }

    public List<Fraction> sortByDenominator(List<Fraction> fractions){
        for (int i = 0; i < fractions.size() - 1; i++){
            for (int j = i + 1; j < fractions.size(); j++){
                if (fractions.get(i).getDenominator()
                    > fractions.get(j).getDenominator()){
                    Fraction temp = fractions.get(i);
                    fractions.set(i, fractions.get(j));
                    fractions.set(j, temp);
                }
            }
        }
        return fractions;
    }

    public List<Fraction> sortByValue(List<Fraction> fractions){
        for (int i = 0; i < fractions.size() - 1; i++){
            for (int j = i + 1; j < fractions.size(); j++){
                if (fractions.get(i).floatValue()
                        > fractions.get(j).floatValue()){
                    Fraction temp = fractions.get(i);
                    fractions.set(i, fractions.get(j));
                    fractions.set(j, temp);
                }
            }
        }
        return fractions;
    }

    //Main test
    public static void main(String[] args) {
        TestFraction testFraction = new TestFraction();
        System.out.println("In ra các phân số trong List: ");
        testFraction.print(testFraction.fractions);

        System.out.println("\nIn ra các phân số theo thứ tự có giá trị tăng dần: ");
        testFraction.print(testFraction.sortByValue(testFraction.fractions));

        System.out.println("\nIn ra các phân số có mẫu số tăng dần: ");
        testFraction.print(testFraction.sortByDenominator(testFraction.fractions));

        System.out.println("\nTìm phân số có giá trị lớn thứ hai trong list fractions: ");
        System.out.println(testFraction.getSecondLargestValue().toString());
    }
}

//        In ra các phân số trong List:
//        "Fraction[427/189]"
//        "Fraction[344/408]"
//        "Fraction[943/464]"
//        "Fraction[416/817]"
//        "Fraction[404/796]"
//        "Fraction[228/676]"
//        "Fraction[856/150]"
//        "Fraction[988/137]"
//        "Fraction[520/715]"
//        "Fraction[220/814]"
//        "Fraction[123/129]"
//        "Fraction[566/293]"
//        "Fraction[901/454]"
//        "Fraction[427/121]"
//        "Fraction[424/960]"
//        "Fraction[89/563]"
//        "Fraction[680/347]"
//        "Fraction[956/305]"
//        "Fraction[714/455]"
//        "Fraction[482/439]"
//        "Fraction[471/610]"
//        "Fraction[395/441]"
//        "Fraction[390/753]"
//        "Fraction[859/604]"
//        "Fraction[740/172]"
//        "Fraction[276/345]"
//        "Fraction[648/183]"
//        "Fraction[550/96]"
//        "Fraction[241/379]"
//        "Fraction[757/996]"
//
//        In ra các phân số theo thứ tự có giá trị tăng dần:
//        "Fraction[89/563]"
//        "Fraction[220/814]"
//        "Fraction[228/676]"
//        "Fraction[424/960]"
//        "Fraction[404/796]"
//        "Fraction[416/817]"
//        "Fraction[390/753]"
//        "Fraction[241/379]"
//        "Fraction[520/715]"
//        "Fraction[757/996]"
//        "Fraction[471/610]"
//        "Fraction[276/345]"
//        "Fraction[344/408]"
//        "Fraction[395/441]"
//        "Fraction[123/129]"
//        "Fraction[482/439]"
//        "Fraction[859/604]"
//        "Fraction[714/455]"
//        "Fraction[566/293]"
//        "Fraction[680/347]"
//        "Fraction[901/454]"
//        "Fraction[943/464]"
//        "Fraction[427/189]"
//        "Fraction[956/305]"
//        "Fraction[427/121]"
//        "Fraction[648/183]"
//        "Fraction[740/172]"
//        "Fraction[856/150]"
//        "Fraction[550/96]"
//        "Fraction[988/137]"
//
//        In ra các phân số có mẫu số tăng dần:
//        "Fraction[550/96]"
//        "Fraction[427/121]"
//        "Fraction[123/129]"
//        "Fraction[988/137]"
//        "Fraction[856/150]"
//        "Fraction[740/172]"
//        "Fraction[648/183]"
//        "Fraction[427/189]"
//        "Fraction[566/293]"
//        "Fraction[956/305]"
//        "Fraction[276/345]"
//        "Fraction[680/347]"
//        "Fraction[241/379]"
//        "Fraction[344/408]"
//        "Fraction[482/439]"
//        "Fraction[395/441]"
//        "Fraction[901/454]"
//        "Fraction[714/455]"
//        "Fraction[943/464]"
//        "Fraction[89/563]"
//        "Fraction[859/604]"
//        "Fraction[471/610]"
//        "Fraction[228/676]"
//        "Fraction[520/715]"
//        "Fraction[390/753]"
//        "Fraction[404/796]"
//        "Fraction[220/814]"
//        "Fraction[416/817]"
//        "Fraction[424/960]"
//        "Fraction[757/996]"
//
//        Tìm phân số có giá trị lớn thứ hai trong list fractions:
//        "Fraction[550/96]"

