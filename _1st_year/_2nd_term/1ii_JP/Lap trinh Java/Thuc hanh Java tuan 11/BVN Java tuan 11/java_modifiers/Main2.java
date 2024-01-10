// abstract class: lop truu tuong
/* Mot abstract phuong thuc thuoc ve mot abstract lop và no khong co phan than.
 Phan than đuoc cung cap boi 1 lop con */
abstract class Main2 {
  public String fname = "John";
  public int age = 24;
  public abstract void study(); // abstract method 
}

// Subclass (inherit from Main)
class Student extends Main2 {
  public int graduationYear = 2018;
  public void study() { // the body of the abstract method is provided here
    System.out.println("Studying all day long");
  }
}
