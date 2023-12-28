package lab2;

import java.util.Arrays;
import java.util.Scanner;

public class GradesStatistics {
    public static void print(int[] array){
        int length = array.length;
        System.out.print("[" + array[0]);
        for (int idx = 1; idx < length; idx++){
            System.out.print(", " + array[idx]);
        }
        System.out.print("]");
    }

    public static double median(int[] array){
        double median;
        Arrays.sort(array);
        if (array.length % 2 != 0){
            median = (double) array[(array.length - 1) / 2];
        } else {
            median = (double) ( array[array.length/2] + array[(array.length - 1) / 2]) / 2;
        }
        return Math.round(median*100.0)/100.0;
    }

    public static double stdDev(int[] array, double average){
        double std = 0.0;
        for (int idx = 0; idx < array.length; idx++){
            std += 1.0 / array.length * (array[idx] - average) * (array[idx] - average);
        }
        std = Math.sqrt(std);
        return Math.round(std*100.0)/100.0;
    }

    public static void main(String[] args) {
        //Declare variables
        Scanner in = new Scanner(System.in);

        //Take input
        System.out.print("Enter the number of students : ");
        int numStudents = in.nextInt();
        while (numStudents <= 0) {             //This make sure the number of students have to >0
            System.out.print("Enter again the number of students (have to >0) : ");
            numStudents = in.nextInt();
        }
        int[] grades = new int[numStudents];   //Allocate the array

        //Read the grade of each student into the array and check all (grade >=0 && grade <=100) or not.
        for (int index = 0; index < grades.length; index++){
            boolean test = true;
            //Flag to check value of grade is (>=0 & <= 100) or not.
            System.out.print("Enter the grade for student " + (index + 1) + ": ");
            grades[index] = in.nextInt();
            if (grades[index] < 0 || grades[index] > 100) {
                test = false;
            }
            while (!test){
                //If test=false then it means the user have to input again until it true
                System.out.print("Enter again the grade for student "
                        + index + " (it have to >=0 and <=100): ");
                test = true;
                //Flag to check value of item is >=0 or not.
                grades[index] = in.nextInt();
                if (grades[index] < 0 || grades[index] > 100) {
                    test = false;
                }
            }
        }
        in.close();

        //Compute result after the user input the right grade for each student
        int max_grade = grades[0];
        int min_grade = grades[0];
        int sum_grade = 0;
        for (int i = 0; i < grades.length; i++){
            sum_grade += grades[i];             //Compute sum of grade of all the students
            for (int j = i; j < grades.length; j++){
                if (max_grade < grades[j]){     //Find max_grade
                    max_grade = grades[j];
                }
                if (min_grade > grades[j]){     //Find min_grade
                    min_grade = grades[j];
                }
            }
        }

        //Print result
        System.out.print("The grades are: ");
        print(grades);
        double average = (double) sum_grade / grades.length;
        System.out.printf("%nThe average is : ");
        System.out.printf("%.2f%n", average);
        System.out.print("The median is : ");
        System.out.printf("%.2f%n", median(grades));
        System.out.println("The minimum is : " + min_grade);
        System.out.println("The maximum is : " + max_grade);
        System.out.print("The standard deviation is : ");
        System.out.printf("%.2f%n", stdDev(grades, stdDev(grades, average)));
    }
}