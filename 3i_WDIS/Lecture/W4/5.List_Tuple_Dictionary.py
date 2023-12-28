'''
List có thể sửa đổi phần tử []
Tuple không thể sửa đổi phần tử () - kiểu dữ liệu bất biến sau khi tạo
Dictionary có thể sửa đổi phần tử {}
'''

# List
print("Learn about list ________")
# Khai báo 1 list
List1 = [1,2,3,4,5] # List có 5 phần tử cùng kiểu dữ liệu
List2 = [1,"Hello",True, 3.5] # List có 4 phần tử khác kiểu dữ liệu
List3 = list((1,2,3,4,5)) # List có 5 phần tử cùng kiểu dữ liệu

# Truy cập phần tử
element_0 = List1[0]
element_3 = List1[3]
print(element_0)
print(element_3)

# Thêm phần tử vào list
List1.append(6) # Thêm 1 phần tử
print(List1)
List1.extend([7,8]) # Nối 1 danh sách khác vào cuối danh sách hiện tại
print(List1)

# Chèn phần tử trong list
List1.insert(2, 9) # Chèn 1 phần tử giá trị 9 vào list tại index = 2
print(List1)

# Xóa phần tử trong list
List1.append(9)
print(List1)
List1.remove(9) # Xóa phần tử 9 đầu tiên trong list
print(List1)

List1.pop() # Xóa phần tử cuối cùng trong list
print(List1)
List1.pop(2) # Xóa phần tử tại index = 2 trong list
print(List1)

List1.clear() # Xóa list
print(List1)

# Truy vấn trong list
print(List3.index(3)) # Trả về index của phần tử tham số đầu tiên xuất hiện
print(List3.count(3)) # Trả về số lần phần tử tham số đầu tiên xuất hiện
print(List3.sort()) # Sắp xếp list tăng dần
print(List3.sort(reverse=True)) # Sắp xếp list giảm dần
print(List3.reverse()) # Ngược đảo lại list

# Tuple
print("Learn about tuple ________")
Tuple1 = (1,2,3,4,5)
Tuple2 = (1,"Hello",True, 3.5)
Tuple3 = tuple((1,2,3,4,5))

# Truy cập phần tử
print(Tuple1[0])

# Thêm phần tử vào tuple (bằng cách tạo 1 tuple mới nhờ kết hợp tuple cũ với 1 tuple mới)
Tuple1 += (6,) # chúng ta sử dụng dấu phẩy (,) sau element_to_add để đảm bảo rằng element_to_add được xem như một tuple duy nhất thay vì một giá trị đơn lẻ.
print(Tuple1)

# Thêm nhiều phần tử vào tuple (bản chất là tạo 1 tuple mới)
Tuple1 += (7,8) 
print(Tuple1)

# Tuple1 -= (7,8) # Lệnh này sẽ báo lỗi vì unsupported operand type(s) for -=: 'tuple' and 'tuple'
# print(Tuple1)

# Các phương thức của tuple như count(), index() hoạt động tương tự như với list
print("Các phương thức của tuple như count(), index() cơ bản hoạt động tương tự như với list!")

# Dictionary
print("Learn about dictionary ________")
my_dict = {'name': 'John', 'age': 30, 'city': 'New York'}
print(my_dict['name'])
print(my_dict['age'])
print(my_dict['city'])

print(my_dict.get('name'))
print(my_dict.get('age'))
print(my_dict.get('city'))

print(my_dict.get('gender', 'Male')) # Trả về gender là Male khi không có gender trong dictionary trước đó

print(my_dict.keys())
print(my_dict.values())
print(my_dict.items())

print(my_dict.pop('name'))
print(my_dict.popitem()) # Xóa phần tử cuối cùng trong dictionary
print(my_dict.clear()) # Xóa dictionary
print(my_dict)
