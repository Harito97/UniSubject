package homework2;

import java.util.Scanner;

public class GradesStatistics {

    public final int GRADE_MINIMUM = 0;
    public final int GRADE_MAXIMUM = 100;

    public int[] grades;

    public static void main(String[] args) {
        GradesStatistics aGradesStatistics = new GradesStatistics();
        aGradesStatistics.readGrades();
        System.out.printf("The average is %1$.2f\n", aGradesStatistics.average());
        System.out.printf("The minimum is %1$d\n", aGradesStatistics.min());
        System.out.printf("The maximum is %1$d\n", aGradesStatistics.max());
    }

    public void readGrades(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numberStudents = sc.nextInt();

        grades = new int[numberStudents];

        int i = 0;
        while (i < numberStudents){
            System.out.printf("Enter the grade for student %1$d: ", (i+1));
            int grade = sc.nextInt();
            if (GRADE_MINIMUM <= grade && grade <= GRADE_MAXIMUM){
                grades[i] = grade;
                i++;
            } else {
                System.out.println("Error! Grade must be integer between 0 and 100!");
            }
        }
    }

    public int min(){
        if (grades.length == 0){
            return 0;
        }

        int min = grades[0];
        for(int i = 0; i < grades.length; i++){
            min = (min > grades[i] ? grades[i] : min);
        }
        return min;
    }

    public int max(){
        if (grades.length == 0){
            return 0;
        }

        int max = grades[0];
        for (int i = 0; i < grades.length; i++){
            max = (max < grades[i] ? grades[i] : max);
        }
        return max;
    }

    public double average(){
        if (grades.length == 0){
            return 0.0;
        }

        double sum = 0.0;
        for (int i = 0; i < grades.length; i++){
            sum += grades[i] ;
        }
        return (sum/grades.length);
    }


}
