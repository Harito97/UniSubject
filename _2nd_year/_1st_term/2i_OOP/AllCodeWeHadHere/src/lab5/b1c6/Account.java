package lab5.b1c6;

public class Account {
    //Attributes
    private String id;
    private String name;
    private int balance = 0;

    //Constructors
    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    //Getters
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getBalance() {
        return balance;
    }

    //APIs
    public int credit(int amount){
        this.balance += amount;
        return this.balance;
    }
    public int debit(int amount){
        if (amount <= this.balance){
            this.balance -= amount;
        } else {
            System.out.print("amount exceeded");
        }
        return this.balance;
    }
    public int transferTo(Account another, int amount){
        if (amount <= this.balance){
            this.balance -= amount;
            another.credit(amount);
        } else {
            System.out.print("amount exceeded");
        }
        return this.balance;
    }

    @Override
    public String toString() {
        return "Account[" +
                "id = " + id +
                ", name = " + name +
                ", balance = " + balance +
                ']';
    }
}
