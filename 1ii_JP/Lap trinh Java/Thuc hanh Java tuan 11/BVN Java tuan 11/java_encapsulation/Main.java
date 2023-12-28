public class Main {
  public static void main(String[] args) {
    System.out.println("Dong goi - su dung phuong thuc get va set de truy cap thuoc tinh cua 1 class private: ");
    Person myObj = new Person();
    myObj.setName("John"); // Set the value of the name variable to "John"
    System.out.println(myObj.getName());
  }
}

// Outputs "John"