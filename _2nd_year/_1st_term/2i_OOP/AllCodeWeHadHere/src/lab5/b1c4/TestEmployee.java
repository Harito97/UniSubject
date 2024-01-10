package lab5.b1c4;

import lab5.b1c4.Employee;

public class TestEmployee {
    public static void main(String[] args) {
        //This is the second TestMain
        //Test constructor and toString()
        Employee e1 = new Employee(8, "Peter", "Tan", 2500);
        System.out.println(e1);     //toString();

        //Test Setters and Getters
        e1.setSalary(999);
        System.out.println(e1);     //toString();
        System.out.println("id is: " + e1.getId());
        System.out.println("first name is: " + e1.getFirstName());
        System.out.println("last name is: " + e1.getLastName());
        System.out.println("salary is: " + e1.getSalary());

        System.out.println("name is: " + e1.getName());
        System.out.println("annual salary is: " + e1.getAnnualSalary());

        //Test raiseSalary()
        System.out.println(e1.raiseSalary(10));
        System.out.println(e1);

        //This is the first TestMain
//        Employee test = new Employee(001, "Hieu", "Vu Quang", 50000);
//        //Print all information
//        System.out.println(test.toString());
//        //Take salary in 1 year
//        System.out.println("Salary 1 year is: " +
//                test.getAnnualSalary());
//        //Increasing salary to 79%
//        int percent = 79;
//        System.out.println("Salary after increasing " +
//                percent + " is: " + test.raiseSalary(percent));
    }
}
