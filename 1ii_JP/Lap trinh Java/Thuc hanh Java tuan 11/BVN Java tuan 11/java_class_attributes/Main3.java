public class Main3 {
  final int x = 10;

  public static void main(String[] args) {
    Main3 myObj = new Main3();
    //myObj.x = 25; // will generate an error: cannot assign a value to a final variable
    System.out.println("Tao thuoc tinh final int x de khong the ghi de gia tri cua bien x: ");
    System.out.println(myObj.x);
  }
}