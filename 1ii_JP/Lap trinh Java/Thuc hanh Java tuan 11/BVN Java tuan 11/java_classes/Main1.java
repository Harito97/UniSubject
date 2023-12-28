public class Main1 {
  int x = 5;

  public static void main(String[] args) {
    Main1 myObj1 = new Main1();  // Object 1
    Main1 myObj2 = new Main1();  // Object 2
    System.out.println("Su dung 1 class, tao nhieu doi tuong: ");
    System.out.println(myObj1.x);
    System.out.println(myObj2.x);
  }
}