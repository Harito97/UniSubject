package oop_exersises_for_final_examination;

public class TestAuthor {
    public static void main(String[] args) {
        Author TanAnTeck = new Author("Tan An Teck", "ahteck@nowhere.com", 'm'); // Test the constructor
        System.out.println(TanAnTeck); // Test toString()
        TanAnTeck.setEmail("paulTan@nowhere.com"); // Test setter
        System.out.println("name is: " + TanAnTeck.getName()); // Test getter
        System.out.println("eamil is: " + TanAnTeck.getEmail()); // Test getter
        System.out.println("gender is: " + TanAnTeck.getGender()); // Test getter
    }
}
