package oop_exersises_for_final_examination;

public class Book2 {
    //Attributes
    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    //Constructor
    public Book2(String name, Author[] authors, double price){
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    public Book2(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    //Getters & Setters
    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
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
        String output = "Book[name=" + name +
                ",authors={" + authors[0].toString() + ",";
        for (int i = 1; i < authors.length; i++){
            output += "," + authors[i].toString();
        }
        output += "},price=" + + price +
                ",qty=" + qty + "]";
        return output;
    }

    public String getAuthorName() {
        String output = "\"" + authors[0].getName() + ",";
        for (int i = 1; i < authors.length; i++){
            output += "," + authors[i].getName();
        }
        return output + "\"";
        // cannot use author.name
        // as name is private in Author class
    }
}
