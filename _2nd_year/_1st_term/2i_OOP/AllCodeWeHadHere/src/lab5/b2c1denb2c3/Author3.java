package lab5.b2c1denb2c3;

public class Author3 {
    //Attributes
    private String name;
    private String email;

    //Constructor
    public Author3(String name, String email){
        this.name = name;
        this.email = email;
    }

    //Getters & Setter

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Nen co ca ham doi ten va gioi tinh
    //Vi co the do nhap nham thong tin
    //Or tac gia doi lai ten khai sinh or chuyen gioi ma

    //API
    @Override
    public String toString(){
        return "Author[name = " + name +
                ", email = " + email + "]";
    }
}
