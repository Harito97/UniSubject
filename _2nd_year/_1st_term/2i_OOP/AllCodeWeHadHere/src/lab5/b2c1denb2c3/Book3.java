package lab5.b2c1denb2c3;

public class Book3 {
    //Attributes
    private String isbn;
    private String name;
    private Author3 author3;
    private double price;
    int qty = 0;

    //Constructors
    public Book3(String isbn, String name, Author3 author3, double price) {
        this.isbn = isbn;
        this.name = name;
        this.author3 = author3;
        this.price = price;
    }

    public Book3(String isbn, String name, Author3 author3, double price, int qty) {
        this.isbn = isbn;
        this.name = name;
        this.author3 = author3;
        this.price = price;
        this.qty = qty;
    }

    //Getters Setters
    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public Author3 getAuthor3() {
        return author3;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getAuthorName(){
        return author3.getName();
    }

    public String toString(){
        return "Book[isbn = " + this.isbn +
                ", name = " + this.name +
                ", " + author3.toString() +
                ", price = " + this.price +
                ", qty = " + this.qty +"]";
    }
}
