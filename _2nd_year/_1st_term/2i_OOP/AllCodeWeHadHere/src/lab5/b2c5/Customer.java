package lab5.b2c5;

public class Customer {
    private int ID;
    private String name;
    private char gender;

    public Customer(int ID, String name, char gender){
        if (gender == 'm' || gender == 'f'){
            this.ID = ID;
            this.name = name;
            this.gender = gender;
        } else {
            System.out.print("That information can't be true.");
        }
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public String toString(){
        return "\"" + this.name +
                "(" + this.ID + ")\"";
    }
}
