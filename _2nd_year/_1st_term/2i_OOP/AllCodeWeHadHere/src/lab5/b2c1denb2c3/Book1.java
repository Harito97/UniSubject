package lab5.b2c1denb2c3;

public class Book1 {
    //Attributes
    private String name;
    private Author1and2 author1and2;
    private double price;
    private int qty = 0;

    //Constructor
    public Book1(String name, Author1and2 author1and2, double price){
        this.name = name;
        this.author1and2 = author1and2;
        this.price = price;
    }

    public Book1(String name, Author1and2 author1and2, double price, int qty) {
        this.name = name;
        this.author1and2 = author1and2;
        this.price = price;
        this.qty = qty;
    }

    //Getters & Setters
    public String getName() {
        return name;
    }

    public Author1and2 getAuthor() {
        return author1and2;
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

    //API
    public String toString(){
        return "Book[name = " + name +
                ", " + author1and2.toString() +
                ", price = " + price +
                ", qty = " + qty + "]";
    }

    public String getAuthorName() {
        return author1and2.getName();
        // cannot use author.name
        // as name is private in Author class
    }
}
