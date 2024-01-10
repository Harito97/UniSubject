package oop_exersises_for_final_examination;

public class TestInvoiceItem {
    public static void main(String[] args) {
        InvoiceItem test = new InvoiceItem("007",
                "Ten lua hanh trinh", 50, 5000000.0);
        //Điều kỳ diệu of printf
        System.out.println("Tong gia tri goi hang la: ");
        System.out.printf("%1.2f USD", test.getTotal());
        System.out.printf("%nThong tin goi hang la: %n%s", test.toString());
    }
}
