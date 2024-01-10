public class Person {
  private String name; // private = restricted access

  // Getter
  public String getName() {
    return name;
  }

  // Setter
  public void setName(String newName) {
    this.name = newName;
  }
}
/*
Giải thích ví dụ
Phương getthức trả về giá trị của biến name.

Phương setthức nhận một tham số ( newName) và gán nó cho namebiến.
Từ thiskhóa được sử dụng để chỉ đối tượng hiện tại.

Tuy nhiên, vì name biến được khai báo là private
nên chúng ta không thể truy cập nó từ bên ngoài lớp này
*/