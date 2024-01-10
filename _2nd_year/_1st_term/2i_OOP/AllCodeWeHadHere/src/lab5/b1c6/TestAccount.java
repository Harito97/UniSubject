package lab5.b1c6;

import lab5.b1c6.Account;

public class TestAccount {
    public static void main(String[] args) {
        //The second test main
        // Test constructor and toString()
        Account a1 = new Account("A101", "Tan Ah Teck", 88);
        System.out.println(a1);  // toString();
        Account a2 = new Account("A102", "Kumar"); // default balance
        System.out.println(a2);

        // Test Getters
        System.out.println("ID: " + a1.getId());
        System.out.println("Name: " + a1.getName());
        System.out.println("Balance: " + a1.getBalance());

        // Test credit() and debit()
        a1.credit(100);
        System.out.println(a1);
        a1.debit(50);
        System.out.println(a1);
        a1.debit(500);  // debit() error
        System.out.println(a1);

        // Test transfer()
        a1.transferTo(a2, 100);  // toString()
        System.out.println(a1);
        System.out.println(a2);

        //The first test main
//        Account a = new Account("09072003", "Harito", 999999999);
//        Account b = new Account("10122002","Hieu");
//        //b duoc cong 1000 vao tai khoan
//        b.credit(1000);
//        System.out.println(b.toString());
//        //b bi tru 50000 vao tai khoan
//        b.debit(50000);
//        System.out.printf("%n%s%n", b.toString());
//        //a chuyen b 50000000 vao tai khoan
//        a.transferTo(b, 50000000);
//        System.out.print("Sau khi a chuyen b 50tr: ");
//        //hien thong tin cua ca a va b
//        System.out.printf("%n%s%n%s", a.toString(), b.toString());
    }
}
