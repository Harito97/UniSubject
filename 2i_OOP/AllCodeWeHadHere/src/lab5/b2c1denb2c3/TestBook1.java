package lab5.b2c1denb2c3;

import lab5.b2c1denb2c3.Author1and2;
import lab5.b2c1denb2c3.Book1;

public class TestBook1 {
    public static void main(String[] args) {
        // Construct an author instance
        Author1and2 ahTeck = new Author1and2("Tan Ah Teck", "ahteck@nowhere.com", 'm');
        System.out.println(ahTeck); // Author's toString()
        Book1 dummyBook1 = new Book1("Java for dummy", ahTeck, 19.95, 99); // Test Book's Constructor
        System.out.println(dummyBook1); // Test Book's toString()
        // Test Getters and Setters
        dummyBook1.setPrice(29.95);
        dummyBook1.setQty(28);
        System.out.println("name is: " + dummyBook1.getName());
        System.out.println("price is: " + dummyBook1.getPrice());
        System.out.println("qty is: " + dummyBook1.getQty());
        System.out.println("Author is: " + dummyBook1.getAuthor()); // Author's toString()
        System.out.println("Author's name is: " + dummyBook1.getAuthor().getName());
        System.out.println("Author's email is: " + dummyBook1.getAuthor().getEmail());
        // Use an anonymous instance of Author to construct a Book instance
        Book1 anotherBook1 = new Book1("more Java",
                new Author1and2("Paul Tan", "paul@somewhere.com", 'm'), 29.95);
        System.out.println(anotherBook1); // toString()
    }
}
