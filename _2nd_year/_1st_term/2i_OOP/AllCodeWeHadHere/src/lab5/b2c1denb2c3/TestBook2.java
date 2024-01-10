package lab5.b2c1denb2c3;

import lab5.b2c1denb2c3.Author1and2;
import lab5.b2c1denb2c3.Book2;

public class TestBook2 {
    public static void main(String[] args) {
        // Declare and allocate an array of Authors
        Author1and2[] author1and2s = new Author1and2[2];
        author1and2s[0] = new Author1and2("Tan Ah Teck", "AhTeck@somewhere.com", 'm');
        author1and2s[1] = new Author1and2("Paul Tan", "Paul@nowhere.com", 'm');
        // Declare and allocate a Book instance
        Book2 javaDummy = new Book2("Java for Dummy", author1and2s, 19.99, 99);
        System.out.println(javaDummy); // toString()
    }
}
