package oop_exersises_for_final_examination;

public class TestEmployee {
    public static void main(String[] args) {
        Employee test = new Employee(001, "Hieu", "Vu Quang", 50000);
        //Print all information
        System.out.println(test.toString());
        //Take salary in 1 year
        System.out.println("Salary 1 year is: " +
                test.getAnnualSalary());
        //Increasing salary to 79%
        int percent = 79;
        System.out.println("Salary after increasing " +
                percent + " is: " + test.raiseSalary(percent));
    }
}
