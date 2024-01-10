
# Eg cấu trúc của 1 class 
'''
class ClassName:
    def __init__(self, parameters):
        self.parameters = parameters

    def method(self):
        # code do work
        # return if need 
'''

''' 
Lưu ý về cấu trúc trên:
- class: Khai báo bắt đầu của một lớp.
- ClassName: Tên của lớp, đặt theo quy tắc đặt tên biến.
- __init__: Phương thức khởi tạo, được gọi khi một đối tượng mới của lớp được
tạo ra.
- self: Đại diện cho chính đối tượng đó, cho phép truy cập các thuộc tính và
phương thức của lớp
'''

# Eg về 1 class đơn giản
class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age
    
    def introduce(self):
        print(f"Hello, my name is {self.name} and I am {self.age} years old.")

harito = Person("Harito", 20)
print(harito.introduce()) # print Hello, my name is Harito and I am 20 years old.

# Eg về sử dụng kế thừa lớp 