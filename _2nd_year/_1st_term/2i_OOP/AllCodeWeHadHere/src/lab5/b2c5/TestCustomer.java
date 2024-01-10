package lab5.b2c5;

public class TestCustomer {
    public static void main(String[] args) {
        Customer c1 = new Customer(97, "Harito", 'm');
        Account a1 = new Account(97, c1, 970000000.0);
        Account a2 = new Account(1012, c1);
        System.out.println("Account a1: ");
        System.out.println(a1);
        System.out.println("Account a2: ");
        System.out.println(a2);
        System.out.println("a2 withdraw 10000");
        a2.withdraw(10000);
        System.out.println("\na1 trans to a2 9700000");
        a1.withdraw(9700000);
        a2.deposit(9700000);
        System.out.println("Account a1: ");
        System.out.println(a1);
        System.out.println("Account a2: ");
        System.out.println(a2);
    }
}
