package lab5.b2c1denb2c3;

public class Book2 {
    //Attributes
    private String name;
    private Author1and2[] author1and2s;
    private double price;
    private int qty = 0;

    //Constructor
    public Book2(String name, Author1and2[] author1and2s, double price){
        this.name = name;
        this.author1and2s = author1and2s;
        this.price = price;
    }

    public Book2(String name, Author1and2[] author1and2s, double price, int qty) {
        this.name = name;
        this.author1and2s = author1and2s;
        this.price = price;
        this.qty = qty;
    }

    //Getters & Setters
    public String getName() {
        return name;
    }

    public Author1and2[] getAuthors() {
        return author1and2s;
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
        String output = "Book[name = " + name +
                ", authors = {" + author1and2s[0].toString() + ",";
        for (int i = 1; i < author1and2s.length; i++){
            output += ", " + author1and2s[i].toString();
        }
        output += "}, price = " + + price +
                ", qty = " + qty + "]";
        return output;
    }

    public String getAuthorName() {
        String output = "\"" + author1and2s[0].getName() + ", ";
        for (int i = 1; i < author1and2s.length; i++){
            output += ", " + author1and2s[i].getName();
        }
        return output + "\"";
        // cannot use author.name
        // as name is private in Author class
    }
}
