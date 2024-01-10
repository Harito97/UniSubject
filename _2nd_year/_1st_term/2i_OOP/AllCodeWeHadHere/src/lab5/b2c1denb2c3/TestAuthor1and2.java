package lab5.b2c1denb2c3;

import lab5.b2c1denb2c3.Author1and2;

public class TestAuthor1and2 {
    public static void main(String[] args) {
        Author1and2 TanAnTeck = new Author1and2("Tan An Teck", "ahteck@nowhere.com", 'm'); // Test the constructor
        System.out.println(TanAnTeck); // Test toString()
        TanAnTeck.setEmail("paulTan@nowhere.com"); // Test setter
        System.out.println("name is: " + TanAnTeck.getName()); // Test getter
        System.out.println("email is: " + TanAnTeck.getEmail()); // Test getter
        System.out.println("gender is: " + TanAnTeck.getGender()); // Test getter
    }
}
