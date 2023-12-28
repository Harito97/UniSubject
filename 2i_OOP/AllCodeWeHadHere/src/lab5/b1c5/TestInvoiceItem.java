package lab5.b1c5;

import lab5.b1c5.InvoiceItem;

public class TestInvoiceItem {
    public static void main(String[] args) {
        //The second TestMain
        // Test constructor and toString()
        InvoiceItem inv1 = new InvoiceItem("A101", "Pen Red", 888, 0.08);
        System.out.println(inv1);  // toString();

        // Test Setters and Getters
        inv1.setQty(999);
        inv1.setUnitPrice(0.99);
        System.out.println(inv1);  // toString();
        System.out.println("id is: " + inv1.getId());
        System.out.println("desc is: " + inv1.getDesc());
        System.out.println("qty is: " + inv1.getQty());
        System.out.println("unitPrice is: " + inv1.getUnitPrice());

        // Test getTotal()
        System.out.println("The total is: " + inv1.getTotal());

        //The first TestMain
//        InvoiceItem test = new InvoiceItem("007",
//                "Ten lua hanh trinh", 50, 5000000.0);
//        //Điều kỳ diệu of printf
//        System.out.println("Tong gia tri goi hang la: ");
//        System.out.printf("%1.2f USD", test.getTotal());
//        System.out.printf("%nThong tin goi hang la: %n%s", test.toString());
    }
}
