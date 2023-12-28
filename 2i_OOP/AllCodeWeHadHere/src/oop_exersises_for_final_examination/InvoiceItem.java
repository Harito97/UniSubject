package oop_exersises_for_final_examination;

public class InvoiceItem {
    //Properties
    private String id;
    private String desc;
    private int qty;
    private double unitPrice;

    //Constructor
    public InvoiceItem(String id, String desc, int qty, double unitPrice) {
        this.id = id;
        this.desc = desc;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    //Methods
    public String getId() {
        return id;
    }
    public String getDesc() {
        return desc;
    }
    public int getQty() {
        return qty;
    }
    public double getUnitPrice() {
        return unitPrice;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotal(){
        return this.unitPrice * this.qty;
    }

    @Override
    public String toString() {
        return "InvoiceItem[" +
                "id = '" + id + '\'' +
                ", desc = '" + desc + '\'' +
                ", qty = " + qty +
                ", unitPrice = " + unitPrice +
                ']';
    }
}
