package lab5.b1c4;
//This is the exercise 1.4 in the OOP Exercises For Final Examination in week 3 of anh tro giang
public class Employee {
    //Properties
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    //Constructor
    public Employee(int id, String firstName,
                    String lastName, int salary){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    //Methods
    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String getName(){
        return firstName + " " + lastName;
    }
    public int getAnnualSalary(){
        return salary * 12;
    }
    public int raiseSalary(int percent){
        return (int) (this.salary * (percent / 100.0 + 1));
    }
    @Override
    public String toString() {
        return "Employee[" +
                "id = " + id +
                ", name = " + firstName + " " + lastName +
                ", salary = " + salary +
                ']';
    }
}
