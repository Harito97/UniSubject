package lab5.b2c1denb2c3;

import lab5.b2c1denb2c3.Author3;

public class TestAuthor3 {
    public static void main(String[] args) {
        Author3 TanAnTeck = new Author3("Tan An Teck", "ahteck@nowhere.com"); // Test the constructor
        System.out.println(TanAnTeck); // Test toString()
        TanAnTeck.setEmail("paulTan@nowhere.com"); // Test setter
        System.out.println("name is: " + TanAnTeck.getName()); // Test getter
        System.out.println("email is: " + TanAnTeck.getEmail()); // Test getter
    }
}
