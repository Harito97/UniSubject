package oop_exersises_for_final_examination;

public class TestAccount {
    public static void main(String[] args) {
        Account a = new Account("09072003", "Harito", 999999999);
        Account b = new Account("10122002","Hieu");
        //b duoc cong 1000 vao tai khoan
        b.credit(1000);
        System.out.println(b.toString());
        //b bi tru 50000 vao tai khoan
        b.debit(50000);
        System.out.printf("%n%s%n", b.toString());
        //a chuyen b 50000000 vao tai khoan
        a.transferTo(b, 50000000);
        System.out.print("Sau khi a chuyen b 50tr: ");
        //hien thong tin cua ca a va b
        System.out.printf("%n%s%n%s", a.toString(), b.toString());
    }
}
