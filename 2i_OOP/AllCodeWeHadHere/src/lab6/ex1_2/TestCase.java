package lab6.ex1_2;

public class TestCase {
    public static void main(String[] args) {
        Student s1 = new Student("Harito", "HaNoi", "K66A5", 2021, 5850000.0);
        Staff staff1 = new Staff("Harito", "HaNoi", "HUS", 50000000);

        //Test toString()
        System.out.println("Student: " + s1.toString());
        System.out.println("Staff: " + staff1.toString());

        //Test get, set
        System.out.println("Program of student: " + s1.getProgram());
        System.out.println("Year of student: " + s1.getYear());
        System.out.println("Fee of student: " + s1.getFee());
        System.out.println();
        System.out.println("School of staff: " + staff1.getSchool());
        System.out.println("Pay of staff: " + staff1.getPay());
    }
}
