# Eg 1 hàm cơ bản 
# Eg dat ten file nop bai 21002139_b1_tuan1.py
'''
def function_name(parameters):
    return value 
'''

# Ham 1 tham so
def greet(name):
    return f"Hello, {name}!"
message = greet("Harito")
print(message)

# Ham nhieu tham so
def add_number(a, b):
    return a + b

result = add_number(1, 2)
print(result)

# Ham khong co gia tri tra ve
def say_hello():
    print("Hello!")

say_hello()

# Ham co gia tri tra ve
def greet(name = 'User'):
    return f"Hello, {name}!"

message = greet()
print(message)

# Ham co nhieu tham so tuy chon
def calculate_sum(*args):
    total = 0
    for num in args:
        total += num
    return total

result = calculate_sum(1, 2, 3, 4, 5)
print(result) 

'''
Giải thích về def:
- Hàm giúp tạo ra các khối mã có thể tái sử dụng.
- Tham số là các giá trị mà hàm nhận để thực hiện công việc cụ thể.
- Giá trị trả về được sử dụng để trả về kết quả từ hàm. Nếu không có lệnh return,
hàm sẽ trả về None.
- Hàm có thể có bất kỳ số lượng tham số nào, bao gồm cả không có tham số.
- Hàm có thể nhận giá trị đầu vào dưới nhiều dạng như các biến đơn, danh sách,
hoặc thậm chí một số lượng không xác định các biến (dùng *args).
- Giá trị mặc định của tham số có thể được định nghĩa, điều này cho phép gọi
hàm mà không cần truyền giá trị cho tất cả các tham số.
- Hàm có thể gọi trong bất kỳ phần nào của chương trình
'''