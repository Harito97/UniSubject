package lab5.b2c1denb2c3;

public class Author1and2 {
    //Attributes
    private String name;
    private String email;
    private char gender;

    //Constructor
    public Author1and2(String name, String email, char gender){
        if (gender == 'm' || gender == 'f'){
            this.name = name;
            this.email = email;
            this.gender = gender;
        } else {
            System.out.print("That information can't be true.");
        }
    }

    //Getters & Setter

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public char getGender() {
        return this.gender;
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
                ", email = " + email +
                ", gender = " + gender + "]";
    }
}
