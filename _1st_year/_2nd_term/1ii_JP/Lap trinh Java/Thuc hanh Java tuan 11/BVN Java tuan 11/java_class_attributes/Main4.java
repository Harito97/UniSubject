public class Main4 {
  int x = 5;

  public static void main(String[] args) {
    Main4 myObj1 = new Main4();  // Object 1
    Main4 myObj2 = new Main4();  // Object 2
    myObj2.x = 25;             // Sua doi gia tri x trong doi tuong myObj2
    System.out.println("Sua doi gia thuoc tinh cua tung doi tuong: "); 
    System.out.println(myObj1.x);  // Outputs 5
    System.out.println(myObj2.x);  // Outputs 25
  }
}