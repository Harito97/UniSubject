public class Main1 {
  // Static method
  static void myStaticMethod() {
    System.out.println("Static methods can be called without creating objects");
  }

  // Public method
  public void myPublicMethod() {
    System.out.println("Public methods must be called by creating objects");
  }

  // Main method
  public static void main(String[] args) {
    System.out.println("Su khac nhau giua static va public: ");
    myStaticMethod(); // Call the static method

    Main1 myObj = new Main1(); // Create an object of MyClass
    myObj.myPublicMethod(); // Call the public method
  }
}
